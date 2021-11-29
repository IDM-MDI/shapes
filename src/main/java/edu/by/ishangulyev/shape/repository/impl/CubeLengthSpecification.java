package edu.by.ishangulyev.shape.repository.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.repository.CubeSpecification;

public class CubeLengthSpecification implements CubeSpecification
{
    private float lengthFrom;
    private float lengthTo;

    public CubeLengthSpecification(float from,float to)
    {
        this.lengthFrom = from;
        this.lengthTo = to;
    }

    @Override
    public boolean specify(Cube cube)
    {
        float length = cube.getLength();
        return Float.compare(lengthFrom,length) < 0 && Float.compare(lengthTo,length) > 0;
    }
}
