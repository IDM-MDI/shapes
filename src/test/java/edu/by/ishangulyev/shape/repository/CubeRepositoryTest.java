package edu.by.ishangulyev.shape.repository;

import edu.by.ishangulyev.shape.comparator.CubeAreaComparator;
import edu.by.ishangulyev.shape.comparator.CubeIdComparator;
import edu.by.ishangulyev.shape.comparator.CubeVolumeComparator;
import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.factory.ShapeCreator;
import edu.by.ishangulyev.shape.factory.impl.CubeCreator;
import edu.by.ishangulyev.shape.filler.RepositoryFiller;
import edu.by.ishangulyev.shape.observer.CubeObserver;
import edu.by.ishangulyev.shape.observer.impl.CubeObserverImpl;
import edu.by.ishangulyev.shape.repository.impl.CubeIdSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeRepositoryTest
{
    private static RepositoryFiller repositoryFiller;
    private static CubeRepository cubeRepository = CubeRepository.getInstance();
    private static Cube cubeOne;
    private static Cube cubeTwo;
    private static Point[] pointsOne;
    private static Point[] pointsTwo;
    private static CubeObserver observer;
    private static List<Cube> cubeList;

    @BeforeClass
    public static void init() throws CubeException
    {
        cubeList = new ArrayList<>();
        repositoryFiller = new RepositoryFiller();
        observer = new CubeObserverImpl();
        pointsOne = new Point[8];
        pointsTwo = new Point[8];
        for (int i = 0; i < 8; i++)
        {
            pointsOne[i] = new Point();
            pointsTwo[i] = new Point();
        }
        pointsOne[0].setCoordinate(1.0f,1.0f,-1.0f);
        pointsOne[1].setCoordinate(5.0f,1.0f,-1.0f);
        pointsOne[2].setCoordinate(1.0f,5.0f,-1.0f);
        pointsOne[3].setCoordinate(1.0f,1.0f,-5.0f);
        pointsOne[4].setCoordinate(5.0f,5.0f,-1.0f);
        pointsOne[5].setCoordinate(1.0f,5.0f,-5.0f);
        pointsOne[6].setCoordinate(5.0f,1.0f,-5.0f);
        pointsOne[7].setCoordinate(5.0f,5.0f,-5.0f);
        pointsTwo[0].setCoordinate(4.0f,4.0f,-4.0f);
        pointsTwo[1].setCoordinate(15.0f,4.0f,-4.0f);
        pointsTwo[2].setCoordinate(4.0f,15.0f,-4.0f);
        pointsTwo[3].setCoordinate(4.0f,4.0f,-15.0f);
        pointsTwo[4].setCoordinate(15.0f,15.0f,-4.0f);
        pointsTwo[5].setCoordinate(4.0f,15.0f,-15.0f);
        pointsTwo[6].setCoordinate(15.0f,4.0f,-15.0f);
        pointsTwo[7].setCoordinate(15.0f,15.0f,-15.0f);

        ShapeCreator creator = new CubeCreator();
        cubeOne = creator.createCube(pointsOne);
        cubeTwo = creator.createCube(pointsTwo);

        cubeOne.attach(observer);
        cubeTwo.attach(observer);
        cubeList.add(cubeOne);
        repositoryFiller.fillRepository(cubeList);
    }

    @Test
    public void sizeShouldReturnRepositorySize()
    {
        Assert.assertEquals(cubeRepository.size(),1);
    }
    @Test
    public void methodShouldAddCube()
    {
        cubeRepository.add(cubeTwo);
        Assert.assertEquals(cubeRepository.size(),2);
    }
    @Test
    public void methodShouldDeleteCube()
    {
        cubeRepository.remove(cubeOne);
        Assert.assertEquals(cubeRepository.size(),0);
    }
    @Test
    public void methodShouldClearCube()
    {
        cubeRepository.set(0, cubeTwo);
        cubeRepository.clear();
        Assert.assertEquals(cubeRepository.size(),0);
    }
    @Test
    public void methodShouldSortCubeByID()
    {
        cubeRepository.add(cubeTwo);
        CubeIdComparator comparator = new CubeIdComparator();
        List<Cube> expected = cubeRepository.sort(comparator);
        List<Cube> actual = new ArrayList<>();
        actual.add(cubeOne);
        actual.add(cubeTwo);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void methodShouldSortCubeByArea()
    {
        cubeRepository.add(cubeTwo);
        CubeAreaComparator comparator = new CubeAreaComparator();
        List<Cube> expected = cubeRepository.sort(comparator);
        List<Cube> actual = new ArrayList<>();
        actual.add(cubeOne);
        actual.add(cubeTwo);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void methodShouldSortCubeByVolume()
    {
        cubeRepository.add(cubeTwo);
        CubeVolumeComparator comparator = new CubeVolumeComparator();
        List<Cube> expected = cubeRepository.sort(comparator);
        List<Cube> actual = new ArrayList<>();
        actual.add(cubeOne);
        actual.add(cubeTwo);
        Assert.assertEquals(expected,actual);
    }
}
