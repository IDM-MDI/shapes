package edu.by.ishangulyev.shape.validator;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.service.CubeService;

public class CubeValidator
{
    private CubeValidator(){}
    public static boolean isCube(Point[] points) throws CubeException
    {
        float x,y,z;
        float length = CubeService.lengthCalculate(points);
        int counter = 0;
        int xyzCounter = 0;
        if(!isCountCorrect(points))
        {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < points.length; i++)
        {
            x = points[i].getX();
            y = points[i].getY();
            z = points[i].getZ();
            xyzCounter = 0;
            for (int j = 0; j < points.length || xyzCounter == 3; j++)
            {
                if((points[j].getX() == x) && (points[j].getY() == y) && (Math.abs(points[j].getZ()) == length))
                {
                    xyzCounter++;
                }
                else if((Math.abs(points[j].getX())==length) && (points[j].getY() == y) && (points[j].getZ() == z))
                {
                    xyzCounter++;
                }
                else if((points[j].getX() == x) && (Math.abs(points[j].getY()) == length) && (points[j].getZ() == z))
                {
                    xyzCounter++;
                }
            }
        }
        return result;
    }
    public static boolean isCountCorrect(Point[] points)
    {
        return points.length == 8;
    }


}
