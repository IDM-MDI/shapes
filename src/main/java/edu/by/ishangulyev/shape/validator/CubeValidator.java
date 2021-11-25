package edu.by.ishangulyev.shape.validator;

import edu.by.ishangulyev.shape.entity.Point;

public class CubeValidator
{
    public CubeValidator(){}
    public static boolean isCountCorrect(Point[] points)
    {
        return points.length == 8;
    }


}
