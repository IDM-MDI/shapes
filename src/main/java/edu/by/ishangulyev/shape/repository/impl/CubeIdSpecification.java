package edu.by.ishangulyev.shape.repository.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.repository.CubeSpecification;

public class CubeIdSpecification implements CubeSpecification
{
    private long idFrom;
    private long idTo;

    public CubeIdSpecification(long from,long to)
    {
        this.idFrom = from;
        this.idTo = to;
    }

    @Override
    public boolean specify(Cube cube)
    {
        long id = cube.getId();
        return Long.compare(idFrom,id) < 0 && Long.compare(idTo,id) > 0;
    }
}
