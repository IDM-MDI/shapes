package edu.by.ishangulyev.shape.parser;

import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.validator.CubeLineValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeParser
{
    private static final String REG_EX_DELIMITER = "\\s+";
    private static final int POINT_NUMBER = 8;

    public List<Double> parse(String enterLine) throws CubeException
    {
        if(!CubeLineValidator.isCorrect(enterLine))
        {
            throw new CubeException("Line is empty");
        }
        List<Double> points;
        try
        {
            points = Arrays.stream(enterLine.split(REG_EX_DELIMITER)).map(Double::parseDouble).collect(Collectors.toList());
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new CubeException("");                                                                              //TODO: Add func
        }
        return points;
    }

}
