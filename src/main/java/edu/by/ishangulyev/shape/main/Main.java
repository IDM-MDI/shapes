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
//    private static void createNewList(List<Integer> list1, List<Integer> list2)
//    {
//        int k1 = 0, k2 = 0;
//        while (list1.size() != list2.size() * 2){
//            if (list1.get(k1) > list2.get(k2)){
//                list1.add(k1, list2.get(k2));
//                k2++;
//            }
//            k1++;
//        }
//    }
    static final String filename = "src/main/resources/files/properties.txt";
    public static void main(String[] args) throws CubeException
    {
        CubeFileReader cubeFileReader = new CubeFileReader(filename);
        CubeParser cubeParser = new CubeParser();

        List<String> fileString = cubeFileReader.read();
        List<Float> fileDouble = cubeParser.parse(fileString.get(0));
        System.out.println(fileDouble);
        List<Point> points = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < 8; i++)
        {
            points.add(new Point(fileDouble.get(j++),fileDouble.get(j++),fileDouble.get(j++)));
        }
        CubeServiceImpl cubeService = new CubeServiceImpl();
        System.out.println(cubeService.lengthCalculator(points.toArray(Point[]::new)));
        System.out.println(cubeService.isCube(points.toArray(Point[]::new)));
//        System.out.println(points);
//
//            List<Integer> arraylist1 = new ArrayList<>();
//            arraylist1.add(1);
//            arraylist1.add(3);
//            arraylist1.add(5);
//            List<Integer> arraylist2 = new ArrayList<>();
//            arraylist2.add(2);
//        arraylist2.add(4);
//        arraylist2.add(6);
//        createNewList(arraylist1,arraylist2);
//        System.out.println(arraylist1);
    }


}
