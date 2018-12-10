package by.epam.dmitriysedin.task01.model.logic.check;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.*;

/**
 * Created by Dmitriy Sedin on 09.12.2018.
 */
public class CheckOfTriangleTest {

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
    public Object[][] isTriangleData() {

        Object[][] isTriangleData = new Object[testTriangle.length][2];

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

            isTriangleData[i][0] = sideAB + sideAC != sideBC && sideAB + sideBC != sideAC &&
                    sideAC + sideBC != sideAB;
            isTriangleData[i][1] = testTriangle[i];
        }
        return isTriangleData;
    }

    @DataProvider
    public Object[][] isEquilateralTriangleData() {

        Object[][] isEquilateralTriangleData = new Object[testTriangle.length][2];

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

            isEquilateralTriangleData[i][0] = sideAB == sideAC && sideAB == sideBC;
            isEquilateralTriangleData[i][1] = testTriangle[i];
        }
        return isEquilateralTriangleData;
    }

    @DataProvider
    public Object[][] isIsoscelesTriangleData() {

        Object[][] isIsoscelesTriangleData = new Object[testTriangle.length][2];

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

            isIsoscelesTriangleData[i][0] = sideAB == sideAC || sideAB == sideBC || sideAC == sideBC;
            isIsoscelesTriangleData[i][1] = testTriangle[i];
        }
        return isIsoscelesTriangleData;
    }

    @DataProvider
    public Object[][] isRightTriangleData() {

        Object[][] isRightTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isRightTriangleData[i][0] = squareSideAB + squareSideAC == squareSideBC ||
                    squareSideAB + squareSideBC == squareSideAC ||
                    squareSideAC + squareSideBC == squareSideAB;
            isRightTriangleData[i][1] = testTriangle[i];
        }
        return isRightTriangleData;
    }

    @DataProvider
    public Object[][] isAcuteTriangleData() {

        Object[][] isAcuteTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isAcuteTriangleData[i][0] = squareSideAB + squareSideAC > squareSideBC &&
                    squareSideAB + squareSideBC > squareSideAC &&
                    squareSideAC + squareSideBC > squareSideAB;
            isAcuteTriangleData[i][1] = testTriangle[i];
        }
        return isAcuteTriangleData;
    }

    @DataProvider
    public Object[][] isObtuseTriangleData() {

        Object[][] isObtuseTriangleData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++) {
            double squareSideAB = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2)), 2);
            double squareSideAC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);
            double squareSideBC = Math.pow(Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2)), 2);

            isObtuseTriangleData[i][0] = squareSideAB + squareSideAC < squareSideBC ||
                    squareSideAB + squareSideBC < squareSideAC ||
                    squareSideAC + squareSideBC < squareSideAB;
            isObtuseTriangleData[i][1] = testTriangle[i];
        }
        return isObtuseTriangleData;
    }

    @Test(dataProvider = "isTriangleData")
    public void testIsTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isEquilateralTriangleData")
    public void testIsisEquilateralTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isEquilateralTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isIsoscelesTriangleData")
    public void testIsIsoscelesTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isIsoscelesTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isRightTriangleData")
    public void testisRightTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isRightTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isAcuteTriangleData")
    public void testisAcuteTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isAcuteTriangle(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isObtuseTriangleData")
    public void testisObtuseTriangle(boolean expected, Triangle triangle) throws Exception {
        boolean actual = CheckOfTriangle.isObtuseTriangle(triangle);
        assertEquals(actual, expected);
    }
}
