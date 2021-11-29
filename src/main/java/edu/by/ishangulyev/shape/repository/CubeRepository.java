package edu.by.ishangulyev.shape.repository;

import edu.by.ishangulyev.shape.entity.Cube;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository
{
    private static CubeRepository INSTANCE;
    private final List<Cube> cubeList;

    private CubeRepository()
    {
        cubeList = new ArrayList<>();
    }

    ;

    public static CubeRepository getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new CubeRepository();
        }
        return INSTANCE;
    }

    public int size()
    {
        return cubeList.size();
    }

    public boolean isEmpty()
    {
        return cubeList.isEmpty();
    }

    public boolean contains(Cube o)
    {
        return cubeList.contains(o);
    }

    public void clear()
    {
        cubeList.clear();
    }

    public Cube get(int index)
    {
        return cubeList.get(index);
    }

    public Cube set(int index, Cube element)
    {
        return cubeList.set(index, element);
    }

    public boolean add(Cube cube)
    {
        return cubeList.add(cube);
    }

    public boolean remove(Cube o)
    {
        return cubeList.remove(o);
    }

    public List<Cube> sort(Comparator<? super Cube> c)
    {
        return List.copyOf(cubeList.stream().sorted(c).collect(Collectors.toList()));
    }

    public List<Cube> query(CubeSpecification specification)
    {
        return cubeList.stream().filter(specification::specify)
                .collect(Collectors.toList());
    }
}
