package edu.by.ishangulyev.shape.entity;

import edu.by.ishangulyev.shape.util.IdGenerator;

import java.util.Arrays;

public class Cube
{
    private long id;
    private float length;
    private Point[] points;
    {
        this.id = IdGenerator.getId();
    }
    public Cube() {}
    public Cube(Point[] points) {
        this.points = points;
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + Arrays.hashCode(points);
        result = 31 * result + (int)id;
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (!(obj instanceof Cube))
        {
            return false;
        }
        Cube cube = (Cube) obj;
        return cube.id == id
                && cube.points == points;
    }

    @Override
    public String toString()
    {final StringBuilder stringBuilder = new StringBuilder()
            .append("Cube{ Points( ")
            .append(points)
            .append(" length = ")
            .append(length)
            .append(" }");
        return stringBuilder.toString();
    }

    public long getId()
    {
        return this.id;
    }

}
