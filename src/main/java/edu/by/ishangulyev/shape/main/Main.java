package edu.by.ishangulyev.shape.main;

import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.reader.CubeFileReader;
import edu.by.ishangulyev.shape.service.CubeService;

public class Main
{
    static final String filename = "src/com.ishangulyev/resources/properties.txt";
    public static void main(String[] args) throws CubeException
    {
        Point[] points = new Point[8];
        for (int i = 0; i < points.length; i++)
        {
            points[i] = new Point();
        }
        points[0].setCoordinate(1f,1f,1f);
        points[1].setCoordinate(1f,5f,1f);
        points[2].setCoordinate(5f,1f,1f);
        points[3].setCoordinate(1f,1f,-5f);
        points[4].setCoordinate(5f,5f,1f);
        points[5].setCoordinate(1f,5f,-5f);
        points[6].setCoordinate(5f,5f,-5f);
        points[7].setCoordinate(5f,1f,-5f);
        System.out.println(CubeService.lengthCalculate(points));
    }


}
