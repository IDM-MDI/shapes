package edu.by.ishangulyev.shape.service;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.validator.CubeValidator;

public class CubeService
{
    private float length;

    public float getLength(Point[] points) throws CubeException
    {
        if(length ==0)
        {
           length = lengthCalculate(points);
        }
        return length;
    }
    private float lengthCalculate(Point[] points) throws CubeException
    {
        float   x = points[0].getX(),
                y = points[0].getY(),
                z = points[0].getZ(),
                result = 0;

        if(!CubeValidator.isCountCorrect(points))
        {
            throw new CubeException("Invalid");         //TODO:
        }
        for (int i = 1; i < points.length; i++)
        {
            if((points[i].getX() == x) && (points[i].getY() == y) &&(points[i].getZ() != z))
            {
                result = Math.abs(points[i].getZ());
            }
        }
        return result;
    }

}
