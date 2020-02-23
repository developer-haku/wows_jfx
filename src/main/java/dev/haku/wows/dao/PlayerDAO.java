package dev.haku.wows.dao;

import dev.haku.wows.model.Player;
import org.bson.Document;

import java.util.List;

public interface PlayerDAO {
    List<Player> getAllPlayerFromOneServer(String server);
    List<Player> getAllPlayerFromAllServer();
    List<Double> getWinRatesFromOneServer(String server);
    List<Document> getAllDocumentFromOneServer();
    List<String> getPlayerNameList(String server);
    Player getOnePlayerFromOneServerByName(String server, String player_name);
    Player getOnePlayerFromAllServerByName(String player_name);
    Document findOne();
    void testMethod(String server, String player_name);
}
