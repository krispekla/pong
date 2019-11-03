package pong.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    private Scene gameScene;

    @FXML
    public Button startId;

    public void onStartGame(ActionEvent actionEvent) {

        try {
        Parent root = FXMLLoader.load(getClass().getResource("view/game.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
