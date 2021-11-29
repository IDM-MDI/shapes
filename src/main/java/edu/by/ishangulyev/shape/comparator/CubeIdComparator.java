package edu.by.ishangulyev.shape.comparator;

import edu.by.ishangulyev.shape.entity.Cube;

import java.util.Comparator;

public class CubeIdComparator implements Comparator<Cube>
{
    @Override
    public int compare(Cube o1, Cube o2)
    {
        return Long.compare(o1.getId(),o2.getId());
    }
}
