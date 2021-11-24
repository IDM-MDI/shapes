package edu.by.ishangulyev.shape.validator;

import edu.by.ishangulyev.shape.entity.Point;

public class CubeValidator
{
    private CubeValidator(){}
    public static boolean isCube(Point[] points)
    {
        float a;
        if(!isCountCorrect(points))
        {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < 3; j++)
            {

            }
        }
        return result;
    }
    public static boolean isCountCorrect(Point[] points)
    {
        return points.length == 8;
    }


}
