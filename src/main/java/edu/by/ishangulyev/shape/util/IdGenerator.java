package edu.by.ishangulyev.shape.util;

public class IdGenerator
{
    private static long id;
    private IdGenerator(){};

    static
    {
        id = 0;
    }

    public static long getId()
    {
        return ++id;
    }
}
