package by.epam.dmitriysedin.task01.model.logic;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;
import by.epam.dmitriysedin.task01.model.exception.TriangleNullException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class SidesOfTriangle {

    static final Logger logger = LogManager.getLogger(SidesOfTriangle.class);

    public static double getSideAB(Triangle triangle) throws TriangleNullException{

        TwoDimensionsPoint apexA;
        TwoDimensionsPoint apexB;

        double abscissaA;
        double ordinateA;
        double abscissaB;
        double ordinateB;

        try {
            apexA = triangle.getApexA();
            apexB = triangle.getApexB();

            abscissaA = apexA.getAbscissa();
            ordinateA = apexA.getOrdinate();
            abscissaB = apexB.getAbscissa();
            ordinateB = apexB.getOrdinate();

        } catch (NullPointerException e){
            logger.trace("NullPointerException thrown in <getSideAB>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        logger.trace("<getSideAB> is done");

        return Math.sqrt((Math.pow(abscissaA - abscissaB, 2)) +
                (Math.pow(ordinateA - ordinateB, 2)));
    }

    public static double getSideAC(Triangle triangle) throws TriangleNullException{

        TwoDimensionsPoint apexA;
        TwoDimensionsPoint apexC;

        double abscissaA;
        double ordinateA;
        double abscissaC;
        double ordinateC;

        try {
            apexA = triangle.getApexA();
            apexC = triangle.getApexC();

            abscissaA = apexA.getAbscissa();
            ordinateA = apexA.getOrdinate();
            abscissaC = apexC.getAbscissa();
            ordinateC = apexC.getOrdinate();

        } catch (NullPointerException e){
            logger.trace("NullPointerException thrown in <getSideAC>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        logger.trace("<getSideAC> is done");

        return Math.sqrt((Math.pow(abscissaA - abscissaC, 2)) +
                (Math.pow(ordinateA - ordinateC, 2)));

    }

    public static double getSideBC(Triangle triangle) throws TriangleNullException{

        TwoDimensionsPoint apexB;
        TwoDimensionsPoint apexC;

        double abscissaB;
        double ordinateB;
        double abscissaC;
        double ordinateC;

        try {
            apexB = triangle.getApexB();
            apexC = triangle.getApexC();

            abscissaB = apexB.getAbscissa();
            ordinateB = apexB.getOrdinate();
            abscissaC = apexC.getAbscissa();
            ordinateC = apexC.getOrdinate();

        } catch (NullPointerException e){
            logger.trace("NullPointerException thrown in <getSideBC>");
            throw new TriangleNullException("Triangle is <null> or has a <null> field.");
        }

        logger.trace("<getSideBC> is done");

        return Math.sqrt((Math.pow(abscissaB - abscissaC, 2)) +
                (Math.pow(ordinateB - ordinateC, 2)));
    }
}
