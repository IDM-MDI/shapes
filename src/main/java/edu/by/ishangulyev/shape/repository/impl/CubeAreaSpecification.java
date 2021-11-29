package edu.by.ishangulyev.shape.repository.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.repository.CubeSpecification;

public class CubeAreaSpecification implements CubeSpecification
{
    private float areaFrom;
    private float areaTo;

    public CubeAreaSpecification(float from,float to)
    {
        this.areaFrom = from;
        this.areaTo = to;
    }

    @Override
    public boolean specify(Cube cube)
    {
        float area = cube.getArea();
        return Float.compare(areaFrom,area) < 0 && Float.compare(areaTo,area) > 0;
    }
}
