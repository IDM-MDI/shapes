package edu.by.ishangulyev.shape.factory.impl;
import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.factory.ShapeCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CubeCreator implements ShapeCreator
{
    private static final Logger logger = LogManager.getLogger();
    private static final int POINTS_NUMBER = 8;
    @Override
    public Cube createCube(Point[] points) throws CubeException
    {
        if(points.length != POINTS_NUMBER)
        {
            logger.log(Level.ERROR,"Invalid points count: {}",points.length);
            throw new CubeException("Error. Points count not equal 8");
        }
        logger.log(Level.INFO,"Factory method create new cube");
        return new Cube(points);
    }
}
