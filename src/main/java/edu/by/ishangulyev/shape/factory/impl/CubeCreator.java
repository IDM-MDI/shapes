package edu.by.ishangulyev.shape.factory.impl;
import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.factory.ShapeCreator;

public final class CubeCreator implements ShapeCreator
{

    @Override
    public Cube createCube(int id, String name, Point[] points)
    {
        return new Cube(id,name,points);
    }
}
