package edu.by.ishangulyev.shape.entity;

public class Cube
{
    private int id;
    private String name;
    private float volume;
    private Point[] points;

    public Cube(int id,String name,Point[] points)
    {
        this.id = id;
        this.name = name;
        this.points = new Point[8];
        System.arraycopy(points,0,this.points,0,points.length);
    }


    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + id;
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
        return cube.name.equals(name) && cube.id == id;
    }

    @Override
    public String toString()
    {
        return "{ " + this.name + ": " + id + " }";
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }
}
