package edu.by.ishangulyev.shape.reader;

import edu.by.ishangulyev.shape.exception.CubeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeReaderTest
{
    private final CubeFileReader cubeFileReader = new CubeFileReader();
    private final String filename = "src/main/resources/files/properties.txt";
    @Test
    public void cubeFileReaderShouldReturnValidLine() throws CubeException
    {
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                "1.0 1.0 1.0 5.0 1.0 1.0 1.0 5.0 1.0 1.0 1.0 -5.0 5.0 5.0 1.0 1.0 5.0 -5.0 5.0 5.0 -5.0 5.0 1.0 -5.0",
            "-3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3 -3.3",
            "1.0 1.2 1.0 5.0 1.0 1.3 1.0 5.0 1.0 1.0 1.5 -5.0 5.0 5.0 1.1 1.0 5.0 -5.0 5.1 5.0 -1.0 5.0 1.0 -5.0",
            "1.0 1.0 1.0 6.0 1.0 1.0 1.0 6.0 1.0 1.0 1.0 -6.0 6.0 6.0 1.0 1.0 6.0 -6.0 6.0 6.0 -6.0 6.0 1.0 -6.0"));
        List<String> actual = cubeFileReader.read(filename);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void cubeFileReaderShouldThrowEmptyPathException()
    {
        String line = "";
        String expected = "Incorrect path or unreadable file";
        String actual = Assert.assertThrows(CubeException.class,
                        ()->cubeFileReader.read(line)).
                getMessage();
        Assert.assertEquals(expected,actual);

    }
}
