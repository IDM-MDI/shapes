package edu.by.ishangulyev.shape.main;

import edu.by.ishangulyev.shape.entity.*;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.parser.CubeParser;
import edu.by.ishangulyev.shape.reader.CubeFileReader;
import edu.by.ishangulyev.shape.service.impl.CubeServiceImpl;
import edu.by.ishangulyev.shape.validator.CubeValidator;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    static final String filename = "src/main/resources/files/properties.txt";
    public static void main(String[] args) throws CubeException
    {
        CubeFileReader cubeFileReader = new CubeFileReader();
        CubeParser cubeParser = new CubeParser();
        List<Cube> cubes = new ArrayList<>();
        List<String> fileString = cubeFileReader.read(filename);
        List<Float> fileDouble = cubeParser.parse(fileString.get(0));
        for (int i = 0; i < fileString.size(); i++)
        {
            cubes.add(cubeParser.getCubes(cubeParser.parse(fileString.get(i))));
        }

        System.out.println(cubes);
        CubeServiceImpl cubeService = new CubeServiceImpl();
        for (int i = 0; i < cubes.size(); i++)
        {
            System.out.println(cubeService.isCube(cubes.get(i)));
        }
    }


}
