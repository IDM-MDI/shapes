package edu.by.ishangulyev.shape.repository.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.repository.CubeSpecification;

public class CubeVolumeSpecification implements CubeSpecification
{
    private float volumeFrom;
    private float volumeTo;

    public CubeVolumeSpecification(float from, float to)
    {
        this.volumeFrom = from;
        this.volumeTo = to;
    }

    @Override
    public boolean specify(Cube cube)
    {
        float volume = cube.getVolume();
        return Float.compare(volumeFrom,volume) < 0 && Float.compare(volumeTo,volume) > 0;
    }
}
