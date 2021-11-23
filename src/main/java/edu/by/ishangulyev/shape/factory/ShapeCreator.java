package edu.by.ishangulyev.shape.factory;
import edu.by.ishangulyev.shape.entity.*;
public interface ShapeCreator
{
    Cube createCube(int id, String name, Point[] points);
}
