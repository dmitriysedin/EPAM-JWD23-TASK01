package by.epam.dmitriysedin.task01.model.logic;

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
 * Created by Dmitriy Sedin on 10.12.2018.
 */
public class SidesOfTriangleTest {

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
    public Object[][] getSideABData (){

        Object[][] getSideABData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideAB = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexB().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexB().getOrdinate(), 2));

            getSideABData[i][0] = sideAB;
            getSideABData[i][1] = testTriangle[i];
        }
        return getSideABData;
    }

    @DataProvider
    public Object[][] getSideACData (){

        Object[][] getSideACData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideAC = Math.sqrt(Math.pow(testTriangle[i].getApexA().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexA().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            getSideACData[i][0] = sideAC;
            getSideACData[i][1] = testTriangle[i];
        }
        return getSideACData;
    }

    @DataProvider
    public Object[][] getSideBCData (){

        Object[][] getSideBCData = new Object[testTriangle.length][2];

        for (int i = 0; i < testTriangle.length; i++){
            double sideBC = Math.sqrt(Math.pow(testTriangle[i].getApexB().getAbscissa() -
                    testTriangle[i].getApexC().getAbscissa(), 2) +
                    Math.pow(testTriangle[i].getApexB().getOrdinate() -
                            testTriangle[i].getApexC().getOrdinate(), 2));

            getSideBCData[i][0] = sideBC;
            getSideBCData[i][1] = testTriangle[i];
        }
        return getSideBCData;
    }

    @Test(dataProvider = "getSideABData")
    public void testGetSideAB(Double expected, Triangle triangle) throws Exception {

        double actual = SidesOfTriangle.getSideAB(triangle);

        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "getSideACData")
    public void testGetSideAC(Double expected, Triangle triangle) throws Exception {

        double actual = SidesOfTriangle.getSideAC(triangle);

        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "getSideBCData")
    public void testGetSideBC(Double expected, Triangle triangle) throws Exception {

        double actual = SidesOfTriangle.getSideBC(triangle);

        assertEquals(actual, expected, 0.000001);
    }

}