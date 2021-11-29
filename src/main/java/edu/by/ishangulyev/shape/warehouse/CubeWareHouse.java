package edu.by.ishangulyev.shape.warehouse;

import edu.by.ishangulyev.shape.exception.CubeException;

import java.util.HashMap;
import java.util.Map;

public class CubeWareHouse
{
    private static CubeWareHouse INSTANCE;
    private final Map<Long,CubeProperties> cubePropertiesMap;


    private CubeWareHouse()
    {
        cubePropertiesMap = new HashMap<>();
    }

    public static CubeWareHouse getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new CubeWareHouse();
        }
        return INSTANCE;
    }

    public int size()
    {
        return cubePropertiesMap.size();
    }

    public boolean isEmpty()
    {
        return cubePropertiesMap.isEmpty();
    }

    public boolean containsKey(long key)
    {
        return cubePropertiesMap.containsKey(key);
    }

    public boolean containsValue(CubeProperties value)
    {
        return cubePropertiesMap.containsValue(value);
    }

    public CubeProperties putIfAbsent(Long key, CubeProperties value)
    {
        return cubePropertiesMap.putIfAbsent(key, value);
    }

    public CubeProperties put(Long key, CubeProperties value)
    {
        return cubePropertiesMap.put(key, value);
    }

    public CubeProperties remove(long key) throws CubeException
    {
        if(!cubePropertiesMap.containsKey(key))
        {
            throw new CubeException("No such elements for this key");
        }
        return cubePropertiesMap.remove(key);
    }
    public CubeProperties findCubeProperties(long key) throws CubeException
    {
        try
        {
            return cubePropertiesMap.get(key).clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new CubeException("No such elements for this key");
        }
    }
}
