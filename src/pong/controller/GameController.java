package pong.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static final int SIZE = 23;
//    private static final int[][] DIRECTIONS = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,0],[0,1],[1,-1],[1,0],[1,1]];
    private static final byte BALL_DIRECTION = -1;
    private static int[][] gridFields = new int[SIZE][SIZE];
    @FXML
    public GridPane gameGrid;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button dada;

    @FXML
    private Circle ball;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBoardFields();
        boardRender();
    }

    private void setBoardFields() {
        //Filling Start values
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gridFields[i][j] = 0;

                //Obstacles
                if (i == 8 && (j > 10 && j < 16)) {
                    gridFields[i][j] = 1;
                } else if (i == 6 && (j > 3 && j < 9)) {
                    gridFields[i][j] = 1;
                } else {
                    gridFields[i][j] = 0;
                }
                //Player
                if (i == 22 && (j > 12 && j < 16)) {
                    gridFields[i][j] = 92;
                }
            }
        }

        gridFields[18][16] = 99;

        //Adding GRID Cols and Rows
        for (int i = 0; i < SIZE; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0);
            colConst.setHalignment(HPos.CENTER);
            gameGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < SIZE; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0);
            gameGrid.getRowConstraints().add(rowConst);
        }
    }

    public void boardRender() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (gridFields[i][j]) {

                    case 1:
                        Rectangle temp = new Rectangle();
                        temp.setWidth(55);
                        temp.setHeight(25);
                        temp.setFill(Color.YELLOW);
                        temp.setStroke(Color.YELLOW);
                        gameGrid.add(temp, j, i);
                    case 92:
                        Rectangle player = new Rectangle();
                        player.setWidth(65);
                        player.setHeight(30);
                        player.setFill(Color.DARKGRAY);
                        player.setStroke(Color.DARKSLATEGREY);
                        gameGrid.add(player, j, i);
                        break;
                    case 99:
                        ball.setCenterX(50.0f);
                        ball.setCenterY(50.0f);
                        ball.setRadius(12.0f);
                        ball.setFill(Color.GRAY);
                        gameGrid.add(ball, j, i);
                        break;
                    default:
                        continue;
                }
            }
        }
    }

    private void nextTick() {

    }

    @FXML
    private void klikni(ActionEvent event) {
        dada.setText("test");
    }
}
