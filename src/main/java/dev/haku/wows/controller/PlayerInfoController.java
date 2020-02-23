package dev.haku.wows.controller;

import dev.haku.wows.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.shape.Arc;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInfoController implements Initializable {

    @FXML
    private Label playerNameLabel;

    @FXML
    private Label clanNameLabel;

    @FXML
    private Arc osWinRateRing;

    @FXML
    private Label osWinRateLb;

    @FXML
    private TableView<Player> osBasicTB;

    @FXML
    private TableView<Player> avgBattleValueTB;

    @FXML
    private TableView<ShipTypeStats> shipTypeTB;

    @FXML
    private TableView<ShipTierStats> shipTierTB;

    @FXML
    private TableView<WeaponStats> weaponStatsTB;

    @FXML
    private TableView<Record> recordsTB;

    @FXML
    private TableView<OnlineRecord> olHistoryTB;

    @FXML
    private TableView<ImportantMoment> importantMomentTB;

    @FXML
    private TableView<Rank> rankHistoryTB;

    @FXML
    private TableView<ShipStats> shipStatsTB;


    void setPlayerInfo(Player p) {
        playerNameLabel.setText(p.getPlayerName());
        clanNameLabel.setText('[' + p.getClan() + ']');
        osWinRateRing.setLength(360 * p.getWinRate());
        osWinRateLb.setText(Math.round(p.getWinRate() * 100 * 100.0) / 100.0 + "%");
        osBasicTB.getItems().add(p);
        avgBattleValueTB.getItems().add(p);
        p.getShipTypeStats().forEach(s -> shipTypeTB.getItems().add(s));
        p.getShipTierStats().forEach(s -> shipTierTB.getItems().add(s));
        p.getWeaponStats().forEach(w -> weaponStatsTB.getItems().add(w));
        p.getRecords().forEach(r -> recordsTB.getItems().add(r));
        p.getOnlineHistory().forEach(o -> olHistoryTB.getItems().add(o));
        p.getImportantMoments().forEach(i -> importantMomentTB.getItems().add(i));
        p.getRankHistory().forEach(r -> rankHistoryTB.getItems().add(r));
        p.getShipStats().forEach(s -> shipStatsTB.getItems().add(s));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
