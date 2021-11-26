package edu.by.ishangulyev.shape.service;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;

public interface CubeService
{
    boolean isCube(Point[] points) throws CubeException;
    float volCalculator();
    float areaCalculator();
    float lengthCalculator(Point[] points) throws CubeException;
}
