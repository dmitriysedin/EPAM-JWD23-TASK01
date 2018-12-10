package by.epam.dmitriysedin.task01.model.logic.calculation;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.*;

/**
 * Created by Dmitriy Sedin on 07.12.2018.
 */
public class CalculationOfTriangleTest {

    private static final String SPLIT_REGEX = "\\s+";

    private static Triangle[] testTriangle;

    private String fileName = "D:\\EPAM_JWD23\\files\\TestValues";

    @BeforeClass
    public void initTestTriangleArrayFromFile() {

        List<Triangle> triangles = new ArrayList<>();

        String[] linesFromFile = null;

        try (Stream<String> streamFromFile = Files.lines(Paths.get(fileName))) {
            linesFromFile = streamFromFile.toArray(String[]::new);
        } catch (IOException e) {
            System.out.println(e);
        }

        for (int i = 0; i < linesFromFile.length; i++) {
            String[] paramOfTriangle = linesFromFile[i].split(SPLIT_REGEX);
            Triangle triangle = new Triangle(new TwoDimensionsPoint(Double.parseDouble(paramOfTriangle[0]),
                    Double.parseDouble(paramOfTriangle[0])),
                    new TwoDimensionsPoint(Double.parseDouble(paramOfTriangle[2]),
                            Double.parseDouble(paramOfTriangle[3])),
                    new TwoDimensionsPoint(Double.parseDouble(paramOfTriangle[4]),
                            Double.parseDouble(paramOfTriangle[5])));
            triangles.add(triangle);
        }
        testTriangle = triangles.toArray(new Triangle[triangles.size()]);
    }

    @DataProvider
    public Object[][] perimeterOfTriangleData() {

        Object[][] perimeterOfTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            perimeterOfTriangleData[i][0] = sideAB + sideAC + sideBC;
            perimeterOfTriangleData[i][1] = testTriangle[i];
        }
        return perimeterOfTriangleData;
    }

    @DataProvider
    public Object[][] areaOfTriangleData() {

        Object[][] areaOfTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            double halfPerimeter = (sideAB + sideAC + sideBC) / 2;
            areaOfTriangleData[i][0] = Math.sqrt(halfPerimeter *
                    (halfPerimeter - sideAB) * (halfPerimeter - sideAC) * (halfPerimeter - sideBC));
            areaOfTriangleData[i][1] = testTriangle[i];
        }
        return areaOfTriangleData;
    }

    @Test(dataProvider = "perimeterOfTriangleData")
    public void testPerimeterOfTriangle(Double expected, Triangle triangle) throws Exception {
        double actual = CalculationOfTriangle.perimeterOfTriangle(triangle);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "areaOfTriangleData")
    public void testAreaOfTriangle(Double expected, Triangle triangle) throws Exception {
        double actual = CalculationOfTriangle.areaOfTriangle(triangle);
        assertEquals(actual, expected, 0.000001);
    }
}