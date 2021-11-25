package edu.by.ishangulyev.shape.service.impl;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.service.CubeService;
import edu.by.ishangulyev.shape.validator.CubeValidator;

public class CubeServiceImpl implements CubeService
{
    private float length;
    CubeValidator cubeValidator;

    public CubeServiceImpl()
    {
        cubeValidator = new CubeValidator();
    }
//
//    public float getLength(Point[] points) throws CubeException
//    {
//        if(length ==0)
//        {
//           length = lengthFinder(points);
//        }
//        return length;
////    }
//    public float minFinder(Point[] points) throws CubeException
//    {
//        if(!CubeValidator.isCountCorrect(points))
//        {
//            throw new CubeException("Invalid");         //TODO: Find
//        }
//        float min = 0;
//        float length = lengthCalculator(points);
//        for (int i = 0; i < points.length; i++)
//        {
//            if(Math.abs(points[i].getX()) != length)
//            {
//                min = Math.abs(points[i].getX());
//            }
//        }
//        return min;
//    }


    public float getLength()
    {
        return Float.sum(length,0);
    }

    @Override
    public boolean isCube(Point[] points)
    {
        boolean result = true;
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < points.length; j++)
            {
                if(i == j) continue;
                if(isNeighbor(points[i],points[j]))
                {
                    if(length != lengthHelper(points[i],points[j]))
                    {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public float volCalculator()
    {
        return (float) Math.pow(length,3);
    }

    @Override
    public float areaCalculator()
    {
        return (float) (6 * Math.pow(length,2));
    }

    @Override
    public float lengthCalculator(Point[] points) throws CubeException
    {
        if(!CubeValidator.isCountCorrect(points))
        {
            throw new CubeException("Invalid");         //TODO:
        }
        Point tempPoint = new Point(points[0]);
        float result = 0;
        for (int i = 1; i < points.length; i++)
        {
            if(isNeighbor(tempPoint,points[i]))
            {
                result = lengthHelper(tempPoint,points[i]);
                break;
            }
        }
        this.length = result;
        return result;
    }
    private float lengthHelper(Point pointOne, Point pointTwo)
    {
        Point point = sub(pointOne,pointTwo);
        float result = (float) Math.sqrt((Math.pow(point.getX(),2)
                +(Math.pow(point.getY(),2))
                +(Math.pow(point.getZ(),2))));
        return result;
    }
    private boolean isNeighbor(Point pointOne, Point pointTwo)
    {
        boolean result = false;

        if((pointOne.getX() != pointTwo.getX() && pointOne.getY() == pointTwo.getY() && pointOne.getZ() == pointTwo.getZ())
                ||(pointOne.getX() == pointTwo.getX() && pointOne.getY() != pointTwo.getY() && pointOne.getZ() == pointTwo.getZ())
                ||(pointOne.getX() == pointTwo.getX() && pointOne.getY() == pointTwo.getY() && pointOne.getZ() != pointTwo.getZ()))
        {
            result = true;
        }
        return result;
    }
    private Point sub(Point one, Point two)
    {
        float x,y,z;
        if(Math.abs(one.getX()) >Math.abs(two.getX()))
        {
            x = Math.abs(one.getX()) - Math.abs(two.getX());
        }
        else
        {
            x = Math.abs(two.getX()) - Math.abs(one.getX());
        }
        if(Math.abs(one.getY()) >Math.abs(two.getY()))
        {
            y = Math.abs(one.getY()) - Math.abs(two.getY());
        }
        else
        {
            y = Math.abs(two.getY()) - Math.abs(one.getY());
        }
        if(Math.abs(one.getZ()) >Math.abs(two.getZ()))
        {
            z = Math.abs(one.getZ()) - Math.abs(two.getZ());
        }
        else
        {
            z = Math.abs(two.getZ()) - Math.abs(one.getZ());
        }
        return new Point(x,y,z);
    }
}
