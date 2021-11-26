package edu.by.ishangulyev.shape.factory;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.factory.impl.CubeCreator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class CubeCreatorTest
{
    private final ShapeCreator cubeCreator = new CubeCreator();

    @Test
    public void cubeFactoryShouldCreateCube() throws CubeException
    {
        Point[] points = new Point[8];
        for (int i = 0; i < 8; i++)
        {
            points[i] = new Point();
        }
        points[0].setCoordinate(1.0f,1.0f,-1.0f);
        points[1].setCoordinate(5.0f,1.0f,-1.0f);
        points[2].setCoordinate(1.0f,5.0f,-1.0f);
        points[3].setCoordinate(1.0f,1.0f,-5.0f);
        points[4].setCoordinate(5.0f,5.0f,-1.0f);
        points[5].setCoordinate(1.0f,5.0f,-5.0f);
        points[6].setCoordinate(5.0f,1.0f,-5.0f);
        points[7].setCoordinate(5.0f,5.0f,-5.0f);
        Cube cube = cubeCreator.createCube(points);
        Cube cubeExpected = new Cube(points);
        Assert.assertEquals(cubeExpected,cube);
    }
    @Test
    public void invalidNumberShouldThrowException() throws CubeException
    {
        Point[] points = new Point[9];
        for (int i = 0; i < 9; i++)
        {
            points[i] = new Point();
        }
        points[0].setCoordinate(1.0f,1.0f,-1.0f);
        points[1].setCoordinate(5.0f,1.0f,-1.0f);
        points[2].setCoordinate(1.0f,5.0f,-1.0f);
        points[3].setCoordinate(1.0f,1.0f,-5.0f);
        points[4].setCoordinate(5.0f,5.0f,-1.0f);
        points[5].setCoordinate(1.0f,5.0f,-5.0f);
        points[6].setCoordinate(5.0f,1.0f,-5.0f);
        points[7].setCoordinate(5.0f,5.0f,-5.0f);
        points[8].setCoordinate(5.0f,1.0f,-5.0f);
        Exception exception = Assert.assertThrows(CubeException.class, () -> cubeCreator.createCube(points));
        String actual = exception.getMessage();
        String expected = "Error. Points count not equal 8";
        Assert.assertEquals(expected,actual);
    }
}
