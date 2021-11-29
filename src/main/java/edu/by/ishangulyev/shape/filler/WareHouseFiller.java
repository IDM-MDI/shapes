package edu.by.ishangulyev.shape.filler;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.service.CubeService;
import edu.by.ishangulyev.shape.service.impl.CubeServiceImpl;
import edu.by.ishangulyev.shape.warehouse.CubeProperties;
import edu.by.ishangulyev.shape.warehouse.CubeWareHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WareHouseFiller
{
    private static final Logger logger = LogManager.getLogger();
    public void fillWareHouse(List<Cube> cubeList) {
        CubeService cubeService = new CubeServiceImpl();
        CubeWareHouse wareHouseFiller = CubeWareHouse.getInstance();
        cubeList.forEach((cube)->
        {
            long id = cube.getId();
            if(!wareHouseFiller.containsKey(id))
            {
                try
                {
                    Point[] points = cube.getPoints();
                    float volume = cubeService.volCalculator(points);
                    float area = cubeService.areaCalculator(points);
                    float length = cube.getLength();
                    wareHouseFiller.put(id,new CubeProperties(points,area,volume,length));
                }
                catch (CubeException e)
                {
                    logger.log(Level.ERROR,"Error while filling warehouse");
                }
            }
        });
        logger.log(Level.INFO, "WareHouse filled");
    }
}
