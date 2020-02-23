package dev.haku.wows.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.haku.wows.model.*;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

public class PlayerDAOImpl implements PlayerDAO {
    @Override
    public List<Player> getAllPlayerFromOneServer(String server) {
        return null;
    }

    @Override
    public List<Player> getAllPlayerFromAllServer() {
        return null;
    }

    @Override
    public List<Double> getWinRatesFromOneServer(String server) {
        List<Double> winRateList = new ArrayList<>();

        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection(server + "_player_db");

            FindIterable<Document> list = collection.find(and(eq("set_private", false), eq("removed", false))).sort(new BasicDBObject("_id", 1)).projection(fields(include("overall_stats.win_rate"), excludeId()));
            for (Document document : list) {
                winRateList.add(Math.round(((Document) document.get("overall_stats")).getDouble("win_rate") * 10000.0) / 10000.0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return winRateList;
    }

    @Override
    public List<Document> getAllDocumentFromOneServer() {
        List<Document> d = new ArrayList<Document>();
        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection("test_player_db");

            FindIterable<Document> list = collection.find().sort(new BasicDBObject("_id", 1)).projection(fields(include("player_id", "overall_stats.battles", "overall_stats.win_rate"), excludeId()));
            for (Document document : list) {
                d.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    @Override
    public List<String> getPlayerNameList(String server) {
        List<String> nameList = new ArrayList<String>();
        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection(server + "_player_db");
            FindIterable<Document> list = collection
                    .find(and(eq("set_private", false), eq("removed", false)))
                    .sort(new BasicDBObject("_id", 1))
                    .projection(fields(include("player_name"), excludeId()));
            for (Document d : list) {
                nameList.add(d.getString("player_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameList;
    }

    @Override
    public Player getOnePlayerFromOneServerByName(String server, String player_name) {
        Player p = new Player();
        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection(server + "_player_db");

            Document document = collection.find(new BasicDBObject("player_name", player_name)).first();

            p.setPlayerID(Integer.parseInt(document.getString("player_id")));
            p.setPlayerName(document.getString("player_name"));
            p.setClan(document.getString("clan"));

            Document overAllStats = (Document) document.get("overall_stats");
            p.setBattles(overAllStats.getInteger("battles"));
            p.setWinRate(overAllStats.getDouble("win_rate"));
            p.setPersonalRating(overAllStats.getInteger("personal_rating"));
            p.setBattlesSurvived(overAllStats.getDouble("battles_survived"));

            Document averageBattleValues = (Document) overAllStats.get("avg_battle_values");
            p.setAvgDMG(averageBattleValues.getInteger("avg_dmg"));
            p.setAvgFrags(averageBattleValues.getDouble("avg_frags"));
            p.setAvgShootDown(averageBattleValues.getDouble("avg_shoot_down"));
            p.setAvgEXP(averageBattleValues.getInteger("avg_exp"));
            p.setAvgKD(averageBattleValues.getDouble("avg_kd"));
            p.setAvgSpot(averageBattleValues.getDouble("avg_spot"));
            p.setAvgSpotDMG(averageBattleValues.getInteger("avg_spot_dmg"));
            p.setAvgTier(averageBattleValues.getDouble("avg_tier"));

            List<ShipTypeStats> shipTypeStats = new ArrayList<ShipTypeStats>();
            document.getList("ship_type_stats", Document.class).forEach(d -> {
                shipTypeStats.add(new ShipTypeStats(
                        d.getInteger("battles"),
                        d.getDouble("win_rate"),
                        d.getInteger("personal_rating"),
                        d.getDouble("avg_frags"),
                        d.getInteger("avg_dmg"),
                        d.getDouble("avg_shoot_down"),
                        ((Document) d.get("max_frags")).getInteger("max_frags_number"),
                        ((Document) d.get("max_dmg")).getInteger("max_dmg_number"),
                        ((Document) d.get("max_shoot_down")).getInteger("max_shoot_down_number"),
                        d.getString("type")
                ));
            });
            p.setShipTypeStats(shipTypeStats);

            List<ShipTierStats> shipTierStats = new ArrayList<ShipTierStats>();
            document.getList("ship_tier_stats", Document.class).forEach(d -> {
                shipTierStats.add(new ShipTierStats(
                        d.getInteger("battles"),
                        d.getDouble("win_rate"),
                        d.getInteger("personal_rating"),
                        d.getDouble("avg_frags"),
                        d.getInteger("avg_dmg"),
                        d.getDouble("avg_shoot_down"),
                        ((Document) d.get("max_frags")).getInteger("max_frags_number"),
                        ((Document) d.get("max_dmg")).getInteger("max_dmg_number"),
                        ((Document) d.get("max_shoot_down")).getInteger("max_shoot_down_number"),
                        d.getString("tier")
                ));
            });
            p.setShipTierStats(shipTierStats);

            List<WeaponStats> weaponStats = new ArrayList<WeaponStats>();
            document.getList("weapons_stats", Document.class).forEach(d -> {
                weaponStats.add(new WeaponStats(
                        d.getString("weapon_type"),
                        d.getInteger("total_frags"),
                        d.get("hit_ratio") instanceof Double ? d.getDouble("hit_ratio") : d.getInteger("hit_ratio"),
                        ((Document) d.get("max_kills")).getInteger("max_kills_num"),
                        ((Document) d.get("max_kills")).getString("max_kills_ship")

                ));
            });

            p.setWeaponStats(weaponStats);

            List<Record> records = new ArrayList<Record>();
            document.getList("records", Document.class).forEach(d -> {
                records.add(new Record(
                        d.getString("type"),
                        ((Document) d.get("record")).getInteger("record_num"),
                        ((Document) d.get("record")).getString("record_ship")
                ));
            });
            p.setRecords(records);


            List<ImportantMoment> importantMoments = new ArrayList<ImportantMoment>();
            Document importantMomentsDoc = (Document) document.get("important_moment");
            if (importantMomentsDoc != null) {
                importantMomentsDoc.getList("new_ship_list", Document.class).forEach(d -> {
                    importantMoments.add(new NewShipMoment(
                            d.getInteger("year"),
                            d.getInteger("month"),
                            d.getInteger("day"),
                            d.getString("ship")
                    ));
                });
                importantMomentsDoc.getList("new_record_list", Document.class).forEach(d -> {
                    importantMoments.add(new NewRecordMoment(
                            d.getInteger("year"),
                            d.getInteger("month"),
                            d.getInteger("day"),
                            d.getString("ship"),
                            d.getInteger("number"),
                            d.getString("type")
                    ));
                });
            }

            p.setImportantMoments(importantMoments);

            List<OnlineRecord> onlineHistory = new ArrayList<OnlineRecord>();

            if(document.get("online_history") instanceof ArrayList) {
                document.getList("online_history", Document.class).forEach(d -> {
                    onlineHistory.add(new OnlineRecord(
                            d.getInteger("year"),
                            d.getInteger("month"),
                            d.getInteger("battles")
                    ));
                });
            }

            p.setOnlineHistory(onlineHistory);

            List<ShipStats> shipStats = new ArrayList<ShipStats>();
            document.getList("ship_stats", Document.class).forEach(d -> {
                shipStats.add(new ShipStats(
                        d.getString("ship_name"),
                        "O",
                        false,
                        false,
                        d.getInteger("total_battle"),
                        d.getDouble("win_rate"),
                        d.get("avg_dmg") instanceof Double ? d.getDouble("avg_dmg") : d.getInteger("avg_dmg"),
                        d.get("avg_frags") instanceof Double ? d.getDouble("avg_frags") : d.getInteger("avg_frags"),
                        d.get("avg_plane_kills") instanceof Double ? d.getDouble("avg_plane_kills") : d.getInteger("avg_plane_kills")
                ));
            });
            p.setShipStats(shipStats);

            List<Rank> rankHistory = new ArrayList<Rank>();
            document.getList("rank_history", Document.class).forEach(d -> {
                rankHistory.add(new Rank(
                        d.getString("season"),
                        d.getInteger("rank"),
                        d.getInteger("best_rank"),
                        d.getInteger("battles"),
                        d.getDouble("win_rate")
                ));
            });
            p.setRankHistory(rankHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    private Player parsePlayerDoc(Document document) {
        Player p = new Player();
        p.setPlayerName(document.getString("player_name"));
        p.setClan(document.getString("clan"));

        Document overAllStats = (Document) document.get("overall_stats");
        p.setBattles(overAllStats.getInteger("battles"));
        p.setWinRate(overAllStats.getDouble("win_rate"));
        p.setPersonalRating(overAllStats.getInteger("personal_rating"));
        p.setBattlesSurvived(overAllStats.getDouble("battles_survived"));

        Document averageBattleValues = (Document) overAllStats.get("avg_battle_values");
        p.setAvgDMG(averageBattleValues.getInteger("avg_dmg"));
        p.setAvgFrags(averageBattleValues.getDouble("avg_frags"));
        p.setAvgShootDown(averageBattleValues.getDouble("avg_shoot_down"));
        p.setAvgEXP(averageBattleValues.getInteger("avg_exp"));
        p.setAvgKD(averageBattleValues.getDouble("avg_kd"));
        p.setAvgSpot(averageBattleValues.getDouble("avg_spot"));
        p.setAvgSpotDMG(averageBattleValues.getInteger("avg_spot_dmg"));
        p.setAvgTier(averageBattleValues.getDouble("avg_tier"));

        List<ShipTypeStats> shipTypeStats = new ArrayList<ShipTypeStats>();
        document.getList("ship_type_stats", Document.class).forEach(d -> {
            shipTypeStats.add(new ShipTypeStats(
                    d.getInteger("battles"),
                    d.getDouble("win_rate"),
                    d.getInteger("personal_rating"),
                    d.getDouble("avg_frags"),
                    d.getInteger("avg_dmg"),
                    d.getDouble("avg_shoot_down"),
                    ((Document) d.get("max_frags")).getInteger("max_frags_number"),
                    ((Document) d.get("max_dmg")).getInteger("max_dmg_number"),
                    ((Document) d.get("max_shoot_down")).getInteger("max_shoot_down_number"),
                    d.getString("type")
            ));
        });
        p.setShipTypeStats(shipTypeStats);

        List<ShipTierStats> shipTierStats = new ArrayList<ShipTierStats>();
        document.getList("ship_tier_stats", Document.class).forEach(d -> {
            shipTierStats.add(new ShipTierStats(
                    d.getInteger("battles"),
                    d.getDouble("win_rate"),
                    d.getInteger("personal_rating"),
                    d.getDouble("avg_frags"),
                    d.getInteger("avg_dmg"),
                    d.getDouble("avg_shoot_down"),
                    ((Document) d.get("max_frags")).getInteger("max_frags_number"),
                    ((Document) d.get("max_dmg")).getInteger("max_dmg_number"),
                    ((Document) d.get("max_shoot_down")).getInteger("max_shoot_down_number"),
                    d.getString("tier")
            ));
        });
        p.setShipTierStats(shipTierStats);

        List<WeaponStats> weaponStats = new ArrayList<WeaponStats>();
        document.getList("weapon_stats", Document.class).forEach(d -> {
            weaponStats.add(new WeaponStats(
                    d.getString("weapon_type"),
                    d.getInteger("total_frags"),
                    d.getDouble("hit_ratio"),
                    ((Document) d.get("max_kills")).getInteger("max_kills_num"),
                    ((Document) d.get("max_kills")).getString("max_kills_ship")
            ));
        });
        p.setWeaponStats(weaponStats);

        List<Record> records = new ArrayList<Record>();
        document.getList("records", Document.class).forEach(d -> {
            records.add(new Record(
                    d.getString("type"),
                    ((Document) d.get("record")).getInteger("record_num"),
                    ((Document) d.get("record")).getString("record_ship")
            ));
        });
        p.setRecords(records);


        List<ImportantMoment> importantMoments = new ArrayList<ImportantMoment>();
        Document importantMomentsDoc = (Document) document.get("important_moment");
        importantMomentsDoc.getList("new_ship_list", Document.class).forEach(d -> {
            importantMoments.add(new NewShipMoment(
                    d.getInteger("year"),
                    d.getInteger("month"),
                    d.getInteger("day"),
                    d.getString("ship")
            ));
        });
        importantMomentsDoc.getList("new_record_list", Document.class).forEach(d -> {
            importantMoments.add(new NewRecordMoment(
                    d.getInteger("year"),
                    d.getInteger("month"),
                    d.getInteger("day"),
                    d.getString("ship"),
                    d.getInteger("number"),
                    d.getString("type")
            ));
        });
        p.setImportantMoments(importantMoments);

        List<OnlineRecord> onlineHistory = new ArrayList<OnlineRecord>();
        document.getList("online_history", Document.class).forEach(d -> {
            onlineHistory.add(new OnlineRecord(
                    d.getInteger("year"),
                    d.getInteger("month"),
                    d.getInteger("battles")
            ));
        });
        p.setOnlineHistory(onlineHistory);

        List<ShipStats> shipStats = new ArrayList<ShipStats>();
        document.getList("ship_stats", Document.class).forEach(d -> {
            shipStats.add(new ShipStats(
                    d.getString("ship_name"),
                    "O",
                    false,
                    false,
                    d.getInteger("total_battle"),
                    d.getDouble("win_rate"),
                    d.getDouble("avg_dmg"),
                    d.getDouble("avg_frags"),
                    d.getDouble("avg_plane_kills")
            ));
        });
        p.setShipStats(shipStats);

        List<Rank> rankHistory = new ArrayList<Rank>();
        document.getList("rank_history", Document.class).forEach(d -> {
            rankHistory.add(new Rank(
                    d.getString("season"),
                    d.getInteger("rank"),
                    d.getInteger("best_rank"),
                    d.getInteger("battles"),
                    d.getInteger("win_rate")
            ));
        });
        p.setRankHistory(rankHistory);

        return p;
    }

    @Override
    public Player getOnePlayerFromAllServerByName(String player_name) {
        return null;
    }

    @Override
    public Document findOne() {
        Document d = null;
        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection("test_player_db");

            d = collection.find().first();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    @Override
    public void testMethod(String server, String player_name) {
        Player p = new Player();
        try (MongoClient mc = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mc.getDatabase("wows");
            MongoCollection<Document> collection = db.getCollection(server + "_player_db");

            Document document = collection.find(new BasicDBObject("player_name", player_name)).first();

            List<WeaponStats> weaponStats = new ArrayList<WeaponStats>();
            document.getList("weapons_stats", Document.class).forEach(d -> {
                System.out.println(d.getString("weapon_type"));
                System.out.println(d.getInteger("total_frags"));
                System.out.println(d.get("hit_ratio") instanceof Double ? d.getDouble("hit_ratio") : d.getInteger("hit_ratio"));
                System.out.println(((Document) d.get("max_kills")).getInteger("max_kills_num"));
                System.out.println();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
