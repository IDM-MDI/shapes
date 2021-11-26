package edu.by.ishangulyev.shape.entity;

import java.util.Arrays;

public class Point
{
    private float x = 0,y = 0,z = 0;

    public Point(){}
    public Point(float x,float y,float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode()
    {
        int result = 31;
        result += 17 * result + Float.hashCode(x);
        result += 17 * result + Float.hashCode(y);
        result += 17 * result + Float.hashCode(z);
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (!(obj instanceof Point))
        {
            return false;
        }
        Point point = (Point) obj;
        return Float.compare(point.x,x) == 0
                && Float.compare(point.y,y) == 0
                && Float.compare(point.z,z) == 0;

    }

    public Point(Point point)
    {
        this.x = point.getX();
        this.y = point.getY();
        this.z = point.getZ();
    }

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

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getZ()
    {
        return z;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setZ(float z)
    {
        this.z = z;
    }
    public void setCoordinate(float x,float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setCoordinate(Point point)
    {
        this.x = point.getX();
        this.y = point.getY();
        this.z = point.getZ();
    }
}
