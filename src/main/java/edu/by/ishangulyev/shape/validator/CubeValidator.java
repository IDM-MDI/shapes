package edu.by.ishangulyev.shape.validator;

import edu.by.ishangulyev.shape.entity.Point;

import java.util.Arrays;

public class CubeValidator
{
    public CubeValidator(){}
    public boolean isCountCorrect(Point[] points)
    {
        return points.length == 8;
    }
    public boolean isParamValid(Point[] points)
    {
        return !arePointsNull(points) && isCountCorrect(points);
    }
    public boolean arePointsNull(Point[] points)
    {
        boolean result = false;
        for (int i = 0; i < points.length; i++)
        {
            if(points[i] == null)
            {
                result = true;
            }
        }
        return result;
    }
}
