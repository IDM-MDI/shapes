package edu.by.ishangulyev.shape.comparator;

import edu.by.ishangulyev.shape.entity.Cube;

import java.util.Comparator;

public class CubeVolumeComparator implements Comparator<Cube>
{
    @Override
    public int compare(Cube o1, Cube o2)
    {
        return Float.compare(o1.getVolume(),o2.getVolume());
    }
}
