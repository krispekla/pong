package pong.controller;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static int[][] gridFieldset = new int[32][32];

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
        boardInit();
    }

    private void setBoardFields() {
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                gridFieldset[i][j] = 0;

                if (i > 17 ) {
                    gridFieldset[i][j] = 0;
                }
                else    {
                    gridFieldset[i][j] = 1;
                }

                if ( i == 30 && (j > 20 || j < 24)) {
                    gridFieldset[i][j] = 92;
                }
            }
        }

        gridFieldset[24][16] = 99;


    }

    private void boardInit() {
        final int numCols = 32 ;
        final int numRows = 32 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0);
            colConst.setHalignment(HPos.CENTER);
            gameGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 );
            gameGrid.getRowConstraints().add(rowConst);
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {

//                Ovdje treba ici provjera iz fieldseta koji je i ovisno o tome iscrtati
//                Zapreke za sada staviti rucno
                if ( j == 27 && i == 16) {
                    ball.setCenterX(50.0f);
                    ball.setCenterY(50.0f);
                    ball.setRadius(12.0f);
                    ball.setFill(Color.GRAY);
                    gameGrid.add(ball,i,j);
                }
                if (j == 30 && (i > 14 && i < 19)) {
                    Rectangle temp = new Rectangle();
                    temp.setWidth(45);
                    temp.setHeight(20);
                    temp.setFill(Color.GRAY);
                    temp.setStroke(Color.DARKSLATEGREY);
                    gameGrid.add(temp,i,j);
                }
            }
        }
    }

    @FXML
    private void klikni(ActionEvent event) {
        dada.setText("test");
    }
}
