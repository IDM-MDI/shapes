package edu.by.ishangulyev.shape.main;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.reader.CubeFileReader;

public class Main
{
    static final String filename = "src/com.ishangulyev/resources/properties.txt";
    public static void main(String[] args)
    {
        Point[] points = new Point[8];
        points[0].setCoordinate(1,1,1);
        points[1].setCoordinate(1,5,1);
        points[2].setCoordinate(5,1,1);
        points[3].setCoordinate(1,1,-5);
        points[4].setCoordinate(5,5,-5);
    }


}
