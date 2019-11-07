package pong.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
import pong.model.Point;
import pong.utils.Util;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static pong.utils.Util.fillDirections;

public class GameController implements Initializable {
    Timeline loop;

    private static final int SIZE = 23;
    private static ArrayList<Point> DIRECTIONS;
    private static final byte BALL_DIRECTION = -1;
    private static int[][] gridFields = new int[SIZE][SIZE];
    private static Point _BALL;
    private static Point DIRECTION;
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

        loop = new Timeline();
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.setAutoReverse(false);
        final KeyFrame kf = new KeyFrame(Duration.millis(200), (evt -> nextTick()));
        loop.getKeyFrames().add(kf);
        loop.play();

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

        _BALL = new Point(18, 16);
        gridFields[18][16] = 99;
        DIRECTIONS = fillDirections();
        DIRECTION = new Point();

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
        gameGrid.getChildren().clear();
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
                        Circle ball = new Circle();
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
        calculateNextMove();
        boardRender();
    }

    private void calculateNextMove() {
        int tempX;
        int tempY;


        tempX = _BALL.getX() - 1;
        tempY = _BALL.getY();

        gridFields[_BALL.getX()][_BALL.getY()] = 0;

        gridFields[tempX][tempY] = 99;
        _BALL.setX(tempX);
        _BALL.setY(tempY);
    }

    @FXML
    private void klikni(ActionEvent event) {
        dada.setText("test");
    }
}
