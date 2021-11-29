package edu.by.ishangulyev.shape.filler;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.repository.CubeRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RepositoryFiller
{
    private static final Logger logger = LogManager.getLogger();
    public void fillRepository(List<Cube> cubeList) {
        CubeRepository cubeRepository = CubeRepository.getInstance();
        cubeList.forEach(cubeRepository::add);
        logger.log(Level.INFO, "Repository filled");
    }
}
