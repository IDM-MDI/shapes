package edu.by.ishangulyev.shape.factory.impl;
import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.factory.ShapeCreator;

public final class CubeCreator implements ShapeCreator
{

    @Override
    public Cube createCube(Point[] points)
    {
        return new Cube(points);
    }
}
