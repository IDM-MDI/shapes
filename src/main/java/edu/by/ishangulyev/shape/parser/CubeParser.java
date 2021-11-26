package edu.by.ishangulyev.shape.parser;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.validator.CubeLineValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeParser
{
    private static final String REG_EX_DELIMITER = "\\s+";
    private static final int POINTS_NUMBER = 8;

    public List<Float> parse(String enterLine) throws CubeException
    {
        if(CubeLineValidator.isEmpty(enterLine))
        {
            throw new CubeException("Line is empty");
        }
        List<Float> points;
        try
        {
            points = Arrays.stream(enterLine.split(REG_EX_DELIMITER)).map(Float::parseFloat).collect(Collectors.toList());
        } catch (Exception e)
        {
            throw new CubeException("");                    //TODO: Make Error Line                                                                              //TODO: Add func
        }
        return List.copyOf(points);
    }
    public Cube getCubes(List<Float> coordinates) throws CubeException
    {
        if(coordinates.size() < POINTS_NUMBER)
        {
            throw new CubeException("Invalid points number, its must be 8 or more");
        }
        List<Point> points = new ArrayList<>();
        Point[] tempPoint = new Point[POINTS_NUMBER];

        int j = 0;
        for (int i = 0; j != 24; i++)
        {
            points.add(new Point(coordinates.get(j++),coordinates.get(j++),coordinates.get(j++)));
        }

        for(int i = 0;i<POINTS_NUMBER;i++)
        {
            tempPoint[i] = points.get(i);
        }

        return new Cube(tempPoint);
    }


}
