package edu.by.ishangulyev.shape.entity;

public class Point
{
    private float x = 0,y = 0,z = 0;

    public Point(){}
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
}
