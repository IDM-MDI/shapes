package edu.by.ishangulyev.shape.warehouse;

import edu.by.ishangulyev.shape.entity.Point;

import java.util.Arrays;
import java.util.Objects;

public class CubeProperties implements Cloneable
{
    private Point[] points;
    private float area;
    private float volume;
    private float length;

    public CubeProperties(Point[] points, float area, float volume, float length)
    {
        this.points = points;
        this.area = area;
        this.volume = volume;
        this.length = length;
    }

    @Override
    protected CubeProperties clone() throws CloneNotSupportedException
    {
        return new CubeProperties(points,area,volume,length);
    }

    public Point[] getPoints()
    {
        return points;
    }

    public void setPoints(Point[] points)
    {
        this.points = points;
    }

    public float getArea()
    {
        return area;
    }

    public void setArea(float area)
    {
        this.area = area;
    }

    public float getVolume()
    {
        return volume;
    }

    public void setVolume(float volume)
    {
        this.volume = volume;
    }

    public float getLength()
    {
        return length;
    }

    public void setLength(float length)
    {
        this.length = length;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeProperties that = (CubeProperties) o;
        return Float.compare(that.area, area) == 0 &&
                Float.compare(that.volume, volume) == 0 &&
                Float.compare(that.length, length) == 0 &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode()
    {
        int result = Float.hashCode(area) + Float.hashCode(volume) + Float.hashCode(length);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CubeProperties{").
                append("points=").append(Arrays.toString(points)).
                append(", area=").append(area).
                append(", volume=").append(volume).
                append(", length=").append(length).
                append('}').toString();
    }
}
