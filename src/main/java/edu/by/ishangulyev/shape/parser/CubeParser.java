package edu.by.ishangulyev.shape.parser;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.factory.ShapeCreator;
import edu.by.ishangulyev.shape.factory.impl.CubeCreator;
import edu.by.ishangulyev.shape.validator.CubeLineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeParser
{
    private static final Logger logger = LogManager.getLogger();
    private static final String REG_EX_DELIMITER = "\\s+";
    private static final int POINTS_NUMBER = 8;

    public List<Float> parse(String enterLine) throws CubeException
    {
        if(CubeLineValidator.isEmpty(enterLine))
        {
            logger.log(Level.ERROR,"Empty line");
            throw new CubeException("Line is empty or equals null");
        }
        List<Float> points;
        try
        {
            points = Arrays.stream(enterLine.split(REG_EX_DELIMITER)).map(Float::parseFloat).collect(Collectors.toList());
        } catch (Exception e)
        {
            logger.log(Level.ERROR,"Error while parsing");
            throw new CubeException("Something went wrong");
        }
        return List.copyOf(points);
    }
    public Point[] getPoints(List<Float> coordinates) throws CubeException
    {
        if(coordinates.size() < POINTS_NUMBER)
        {
            logger.log(Level.ERROR,"Points number less than must be: {}",coordinates.size());
            throw new CubeException("Invalid points number, its must be 8 or more");
        }
        Point[] result = new Point[POINTS_NUMBER];

        int j = 0;
        for (int i = 0; j != 24; i++)
        {
            result[i] = new Point(coordinates.get(j++),coordinates.get(j++),coordinates.get(j++));
        }
        logger.log(Level.INFO,"Points successful pass validation");
        return Arrays.copyOf(result,POINTS_NUMBER);
    }


}
