package edu.by.ishangulyev.shape.entity;

public class Point
{
    private float x,y,z;

    @Override
    public String toString()
    {
        final StringBuilder stringBuilder = new StringBuilder()
                .append("Point{ x = ")
                .append(x)
                .append(" y = ")
                .append(y)
                .append(" z = ")
                .append(z)
                .append(" }");
        return stringBuilder.toString();
    }

    public Point(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
