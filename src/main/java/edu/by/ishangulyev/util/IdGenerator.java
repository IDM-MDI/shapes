package edu.by.ishangulyev.util;

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
