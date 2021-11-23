package edu.by.ishangulyev.shape.reader;

import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.validator.CubeLineValidator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeFileReader
{
    private Path path;
    public CubeFileReader(String fileName)
    {
        this.path = Paths.get(fileName);
    }

    public List<String> read() throws CubeException
    {
        if(!CubeLineValidator.isCorrect(path.toString()))
        {
            throw new CubeException("Incorrect path or unreadable file");
        }
        List<String> lines;
        try(Stream<String> streamlines = Files.lines(path))
        {
            lines = streamlines
                    .filter(CubeLineValidator::isLineValid)
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            throw new CubeException("" + path.toString(),e);        //TODO: Make Error Line
        }
        return List.copyOf(lines);
    }

}
