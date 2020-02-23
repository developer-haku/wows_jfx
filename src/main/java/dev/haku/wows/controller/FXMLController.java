package dev.haku.wows.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import dev.haku.wows.dao.PlayerDAO;
import dev.haku.wows.dao.PlayerDAOImpl;
import dev.haku.wows.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private JFXComboBox<String> serverCB;

    @FXML
    private JFXTextField playerNameInputTF;

    @FXML
    private ScrollPane playerInfoSP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serverCB.getItems().addAll("NA", "EU", "AS", "RU", "WORLD");
        serverCB.getSelectionModel().selectFirst();
    }

    @FXML
    void buttonSearchPlayer(MouseEvent event) throws Exception {
        searchPlayer();
    }

    @FXML
    void enterSearchPlayer(KeyEvent event) throws IOException {
        if (event.getCode().equals(KeyCode.ENTER))
            searchPlayer();
    }

    private void searchPlayer() throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("/resources/view/PlayerInfoView.fxml"));
        playerInfoSP.setContent(loader.load());
        PlayerInfoController pController = (PlayerInfoController) loader.getController();
        pController.setPlayerInfo(new PlayerDAOImpl().getOnePlayerFromOneServerByName(serverCB.getValue().toLowerCase(), playerNameInputTF.getText()));
    }
}
