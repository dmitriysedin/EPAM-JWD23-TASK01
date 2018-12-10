package by.epam.dmitriysedin.task01.model.logic.calculation;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.exception.NotTriangleException;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;
import by.epam.dmitriysedin.task01.model.logic.SidesOfTriangle;
import by.epam.dmitriysedin.task01.model.logic.check.CheckOfTriangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class CalculationOfTriangle {

    static final Logger logger = LogManager.getLogger(CalculationOfTriangle.class);

    public static double perimeterOfTriangle (Triangle triangle) throws TriangleNullException, NotTriangleException{

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <perimeterOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }
        logger.trace("<perimeterOfTriangle> is done");
        return SidesOfTriangle.getSideAB(triangle) + SidesOfTriangle.getSideAC(triangle) +
                SidesOfTriangle.getSideBC(triangle);
    }

    public static double areaOfTriangle(Triangle triangle) throws TriangleNullException, NotTriangleException{

        if(!CheckOfTriangle.isTriangle(triangle)){
            logger.trace("NotTriangleException thrown in <areaOfTriangle>");
            throw new NotTriangleException("This coordinates are not triangle.");
        }

        double halfPerimeterOfTriangle = perimeterOfTriangle(triangle) / 2;

        logger.trace("<areaOfTriangle> is done");

        return Math.sqrt(halfPerimeterOfTriangle * (halfPerimeterOfTriangle - SidesOfTriangle.getSideAB(triangle)) *
                (halfPerimeterOfTriangle - SidesOfTriangle.getSideAC(triangle)) *
                (halfPerimeterOfTriangle - SidesOfTriangle.getSideBC(triangle)));
    }
}
