package edu.by.ishangulyev.shape.service.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.service.CubeService;
import edu.by.ishangulyev.shape.validator.CubeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeServiceImpl implements CubeService
{
    private static final Logger logger = LogManager.getLogger();
    private float length;
    CubeValidator cubeValidator;
    PointServiceImpl pointService;

    public CubeServiceImpl()
    {
        cubeValidator = new CubeValidator();
        pointService = new PointServiceImpl();
    }

    private void setLength(Point[] points) throws CubeException
    {
        this.length = lengthCalculator(points);
    }
    public float getLength()
    {
        return Float.sum(length,0);         //Вернул копию, не судите строго :)
    }

    @Override
    public boolean isCube(Point[] points) throws CubeException
    {
        if(!cubeValidator.isCountCorrect(points))
        {
            logger.log(Level.WARN,"Points count less than 8: {}",points.length);
            return false;
        }
        setLength(points);
        boolean result = true;
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < points.length; j++)
            {
                if(i == j) continue;
                if(points[i].equals(points[j])) result = false;

                if(isNeighbor(points[i],points[j]))
                {
                    if(length != lengthHelper(points[i],points[j]))
                    {
                        result = false;
                    }
                }
            }
        }
        logger.log(Level.INFO,"All points coordinates give us cube");
        return result;
    }
    public boolean isCube(Cube cube) throws CubeException
    {
        return isCube(cube.getPoints());
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
        if(!cubeValidator.isCountCorrect(points))
        {
            logger.log(Level.ERROR,"Points number less than 8");
            throw new CubeException("Invalid points number");
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
        return result;
    }
    private float lengthHelper(Point pointOne, Point pointTwo)
    {
        Point point = pointService.absSub(pointOne,pointTwo);
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

}
