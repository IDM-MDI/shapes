package edu.by.ishangulyev.shape.factory;
import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.exception.CubeException;

public interface ShapeCreator
{
    Cube createCube(Point[] points) throws CubeException;

}
