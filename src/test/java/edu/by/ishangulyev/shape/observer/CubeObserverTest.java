package edu.by.ishangulyev.shape.observer;

import edu.by.ishangulyev.shape.comparator.CubeAreaComparator;
import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.factory.ShapeCreator;
import edu.by.ishangulyev.shape.factory.impl.CubeCreator;
import edu.by.ishangulyev.shape.filler.WareHouseFiller;
import edu.by.ishangulyev.shape.observer.impl.CubeObserverImpl;
import edu.by.ishangulyev.shape.warehouse.CubeProperties;
import edu.by.ishangulyev.shape.warehouse.CubeWareHouse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeObserverTest
{
    private static CubeWareHouse wareHouse = CubeWareHouse.getInstance();
    private static CubeObserver observer = new CubeObserverImpl();
    private static ShapeCreator creator = new CubeCreator();
    private static Cube cube;
    private static Point[] points;
    private static List<Cube> cubeList;

    @BeforeClass
    public static void init() throws CubeException
    {
        WareHouseFiller wareHouseFiller = new WareHouseFiller();
        points = new Point[8];
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
        cube = creator.createCube(points);
        cube.setLength();
        cube.setArea();
        cube.setVolume();
        cube.attach(observer);
        cubeList = new ArrayList<>();
        cubeList.add(cube);
        wareHouseFiller.fillWareHouse(cubeList);
    }

    @Test
    public void dataChangedShouldBeTrue() throws CubeException
    {
        CubeProperties oldProperties = wareHouse.getCubeProperties(cube.getId());

        float oldLength = oldProperties.getLength();
        float oldVolume = oldProperties.getVolume();
        float oldArea = oldProperties.getArea();

        cube.changeLength(13);
        cube.setArea();
        cube.setVolume();
        wareHouse.put(cube.getId(), new CubeProperties(points,cube.getArea(),cube.getVolume(),cube.getLength()));
        CubeProperties newProperties = wareHouse.getCubeProperties(cube.getId());
        float newLength = newProperties.getLength();
        float newVolume = newProperties.getVolume();
        float newArea = newProperties.getArea();

        Assert.assertTrue(Float.compare(oldArea,newArea) != 0
                                        &&
                            Float.compare(oldLength,newLength) != 0
                                        &&
                            Float.compare(oldVolume,newVolume) != 0);
    }
}
