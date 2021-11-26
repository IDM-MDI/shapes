package edu.by.ishangulyev.shape.entity;

import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.util.IdGenerator;
import edu.by.ishangulyev.shape.validator.CubeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Cube
{
    private static final Logger logger = LogManager.getLogger();
    private long id;
    private Point[] points;
    {
        this.id = IdGenerator.getId();
    }
    public Cube() {}
    public Cube(Point[] points) throws CubeException
    {
        CubeValidator cubeValidator = new CubeValidator();
        if(!cubeValidator.isParamValid(points))
        {
            logger.log(Level.ERROR,"Invalid parameters: {}",points);
            throw new CubeException("Invalid parameters. Points less than 8 or they are null");
        }
        this.points = points;
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        result += 31 * result + Arrays.hashCode(points);
        result += 31 * result + (int)id;
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (!(obj instanceof Cube))
        {
            return false;
        }
        Cube cube = (Cube) obj;
        return cube.id == id
                && cube.points == points;
    }

    @Override
    public String toString()
    {final StringBuilder stringBuilder = new StringBuilder()
            .append("Cube{ Points( ")
            .append(points)
            .append(" }");
        return stringBuilder.toString();
    }

    public long getId()
    {
        return this.id;
    }

    public Point[] getPoints()
    {
        return Arrays.copyOf(points,8);
    }
}
