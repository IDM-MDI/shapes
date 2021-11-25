package edu.by.ishangulyev.shape.main;

import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.parser.CubeParser;
import edu.by.ishangulyev.shape.reader.CubeFileReader;
import edu.by.ishangulyev.shape.service.impl.CubeServiceImpl;
import edu.by.ishangulyev.shape.validator.CubeValidator;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    static final String filename = "src/main/resources/files/properties.txt";
    public static void main(String[] args) throws CubeException
    {
        CubeFileReader cubeFileReader = new CubeFileReader(filename);
        CubeParser cubeParser = new CubeParser();

        List<String> fileString = cubeFileReader.read();
        List<Float> fileDouble = cubeParser.parse(fileString.get(0));
        System.out.println(fileDouble);
        List<Point> points = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 8; i++)
        {
            points.add(new Point(fileDouble.get(j++),fileDouble.get(j++),fileDouble.get(j++)));
        }
        CubeServiceImpl cubeService = new CubeServiceImpl();
        System.out.println(cubeService.lengthCalculator(points.toArray(Point[]::new)));
        System.out.println(cubeService.isCube(points.toArray(Point[]::new)));
    }


}
