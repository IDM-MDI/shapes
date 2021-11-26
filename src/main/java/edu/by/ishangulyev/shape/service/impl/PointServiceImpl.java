package edu.by.ishangulyev.shape.service.impl;

import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.service.PointService;

public class PointServiceImpl implements PointService
{
    @Override
    public Point absSub(Point one, Point two)
    {
        float x,y,z;
        if(Math.abs(one.getX()) >Math.abs(two.getX()))
        {
            x = Math.abs(one.getX()) - Math.abs(two.getX());
        }
        else
        {
            x = Math.abs(two.getX()) - Math.abs(one.getX());
        }
        if(Math.abs(one.getY()) >Math.abs(two.getY()))
        {
            y = Math.abs(one.getY()) - Math.abs(two.getY());
        }
        else
        {
            y = Math.abs(two.getY()) - Math.abs(one.getY());
        }
        if(Math.abs(one.getZ()) >Math.abs(two.getZ()))
        {
            z = Math.abs(one.getZ()) - Math.abs(two.getZ());
        }
        else
        {
            z = Math.abs(two.getZ()) - Math.abs(one.getZ());
        }
        return new Point(x,y,z);
    }

}
