package edu.by.ishangulyev.shape.observer.impl;

import edu.by.ishangulyev.shape.entity.Cube;
import edu.by.ishangulyev.shape.entity.Point;
import edu.by.ishangulyev.shape.exception.CubeException;
import edu.by.ishangulyev.shape.filler.WareHouseFiller;
import edu.by.ishangulyev.shape.observer.CubeEvent;
import edu.by.ishangulyev.shape.observer.CubeObserver;
import edu.by.ishangulyev.shape.service.CubeService;
import edu.by.ishangulyev.shape.service.impl.CubeServiceImpl;
import edu.by.ishangulyev.shape.warehouse.CubeProperties;
import edu.by.ishangulyev.shape.warehouse.CubeWareHouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserverImpl implements CubeObserver
{
    private static final Logger logger = LogManager.getLogger();

    public CubeObserverImpl(){}

    @Override
    public void propertiesReplaced(CubeEvent event)
    {
        CubeWareHouse wareHouse = CubeWareHouse.getInstance();
        CubeService cubeService = new CubeServiceImpl();
        Cube cube = event.getSource();
        long id = cube.getId();
        try
        {
            Point[] points = cube.getPoints();
            float volume = cubeService.volCalculator(points);
            float area = cubeService.areaCalculator(points);
            float length = cube.getLength();
            wareHouse.put(id,new CubeProperties(points,area,volume,length));
        }
        catch (CubeException e)
        {
            logger.log(Level.ERROR,"Error while replacing properties in warehouse");
        }
    }
}
