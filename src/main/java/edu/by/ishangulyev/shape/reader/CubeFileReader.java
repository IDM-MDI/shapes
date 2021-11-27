package edu.by.ishangulyev.shape.reader;

import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.validator.CubeLineValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeFileReader
{
    private static final Logger logger = LogManager.getLogger();
    private Path path;
    public CubeFileReader() {}

    public List<String> read(String fileName) throws CubeException
    {
        this.path = Paths.get(fileName);
        if(CubeLineValidator.isEmpty(path.toString()))
        {
            logger.log(Level.ERROR,"Incorrect path or incorrect format file: {}",path.toString());
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
            logger.log(Level.ERROR,"Error while reading lines");
            throw new CubeException("Error while reading lines" + path.toString());
        }
        logger.log(Level.INFO,"File successfully read");
        return List.copyOf(lines);
    }

}
