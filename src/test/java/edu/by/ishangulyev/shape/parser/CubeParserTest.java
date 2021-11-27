package edu.by.ishangulyev.shape.parser;

import edu.by.ishangulyev.shape.exception.CubeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeParserTest
{
    private final CubeParser cubeParser = new CubeParser();

    @Test
    public void cubeParserShouldReturnValidList() throws CubeException
    {
        String enterLine = "1.0 1.0 1.0 5.0 1.0 1.0 1.0 5.0 1.0 1.0 1.0 -5.0 5.0 5.0 1.0 1.0 5.0 -5.0 5.0 1.0 -5.0 5.0 5.0 -5.0";
        List<Float> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(1.0f,1.0f,1.0f,
                                    5.0f,1.0f,1.0f,
                                    1.0f,5.0f,1.0f,
                                    1.0f,1.0f,-5.0f,
                                    5.0f,5.0f,1.0f,
                                    1.0f,5.0f,-5.0f,
                                    5.0f,1.0f,-5.0f,
                                    5.0f,5.0f,-5.0f));
        List<Float> actual = cubeParser.parse(enterLine);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void cubeParserShouldThrowsEmplyLineException()
    {
        String line = "";
        String expected = "Line is empty or equals null";
        String actual = Assert.assertThrows(CubeException.class,
                ()->cubeParser.parse(line)).
                getMessage();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void cubeParserShouldThrowsExceptionWhileParsing()
    {
        String line = "3f12f452";
        String expected = "Something went wrong";
        String actual = Assert.assertThrows(CubeException.class,
                        ()->cubeParser.parse(line)).
                getMessage();
        Assert.assertEquals(expected,actual);

    }
}
