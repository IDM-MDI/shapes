package edu.by.ishangulyev.shape.entity;

import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.observer.CubeEvent;
import edu.by.ishangulyev.shape.observer.CubeObservable;
import edu.by.ishangulyev.shape.observer.CubeObserver;
import edu.by.ishangulyev.shape.service.CubeService;
import edu.by.ishangulyev.shape.service.impl.CubeServiceImpl;
import edu.by.ishangulyev.shape.util.IdGenerator;
import edu.by.ishangulyev.shape.validator.CubeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cube implements CubeObservable
{
    private static final Logger logger = LogManager.getLogger();
    private long id;
    private float area;
    private float volume;
    private float length;
    private final int POINTS_COUNT = 8;
    private Point[] points;
    List<CubeObserver> cubeObserverList = new ArrayList<>();

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

    public long getId()
    {
        return this.id;
    }
    public float getArea()
    {
        return area;
    }
    public Point[] getPoints()
    {
        return Arrays.copyOf(points,POINTS_COUNT);
    }
    public float getVolume()
    {
        return volume;
    }
    public float getLength()
    {
        return length;
    }

    public void setVolume() throws CubeException
    {
        if(points == null)
        {
            logger.log(Level.ERROR,"Trying to set volume an empty points");
            throw new CubeException("Points are null");
        }
        else
        {
            CubeService cubeService = new CubeServiceImpl();
            cubeService.lengthCalculator(points);
        }
    }
    public void setArea() throws CubeException
    {
        if(points == null)
        {
            logger.log(Level.ERROR,"Trying to set area an empty points");
            throw new CubeException("Points are null");
        }
        else
        {
            CubeService cubeService = new CubeServiceImpl();
            cubeService.areaCalculator();
        }
    }
    public void setLength() throws CubeException
    {
        if(points == null)
        {
            logger.log(Level.ERROR,"Trying to set volume an empty points");
            throw new CubeException("Points are null");
        }
        CubeService cubeService = new CubeServiceImpl();
        this.length = cubeService.lengthCalculator(points);
    }
    public void changePointCoordinate(int key,Point point) throws CubeException         //TODO: Just for test
    {
        if(key > POINTS_COUNT || key < 0)
        {
            throw new CubeException("Error key number");
        }
        points[key] = point;
    }
    public void changeLength(float newLength) throws CubeException         //TODO: Just for test
    {
        if(newLength < 0)
        {
            throw new CubeException("Length less that 0");
        }
        this.length = newLength;
    }
    @Override
    public int hashCode()
    {
        int result = 17;
        result += 31 * result + Arrays.hashCode(points);
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
        return Arrays.equals(points, cube.points);
    }

    @Override
    public String toString()
    {
        final StringBuilder stringBuilder = new StringBuilder()
            .append("Cube{ ")
            .append(Arrays.toString(points))
            .append(" }");
        return stringBuilder.toString();

    }
    @Override
    public void notifyObservers()
    {
        cubeObserverList.forEach((observer ->
        {
            if(observer!=null)
            {
                CubeEvent cubeEvent = new CubeEvent(this);
                observer.propertiesReplaced(cubeEvent);
            }
        }));
    }
    @Override
    public void detach(CubeObserver observer)
    {
        cubeObserverList.remove(observer);
    }
    @Override
    public void attach(CubeObserver observer)
    {
        cubeObserverList.add(observer);
    }
}
