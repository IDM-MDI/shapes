package edu.by.ishangulyev.shape.validator;

import edu.by.ishangulyev.shape.entity.Point;

public class CubeValidator
{
    public CubeValidator(){}
    public boolean isCountCorrect(Point[] points)
    {
        return points.length == 8;
    }
    public boolean isParamValid(Point[] points)
    {
        boolean result = true;
        if(!isCountCorrect(points))
        {
            result = false;
        }
        for (int i = 0; i < points.length; i++)
        {
            if(points[i] == null)
            {
                result = false;
            }
        }
        return result;
    }

}
