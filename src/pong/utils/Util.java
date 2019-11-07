package pong.utils;

import pong.model.Point;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public Point calculateNextDirection() {

        return new Point();
    }

    public static ArrayList<Point> fillDirections() {
        ArrayList<Point> temp = new ArrayList<>();

//        dvije for petlje da napune
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
            temp.add(new Point(i,j));
            }}

        return  temp;
    }
}
