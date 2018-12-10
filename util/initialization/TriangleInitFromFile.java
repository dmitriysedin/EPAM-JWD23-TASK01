package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;
import by.epam.dmitriysedin.task01.model.exception.EmptyFileException;
import by.epam.dmitriysedin.task01.model.exception.FileNotExistsException;
import by.epam.dmitriysedin.task01.model.exception.ReadFromFileException;
import by.epam.dmitriysedin.task01.model.exception.TypeOfFileException;
import by.epam.dmitriysedin.task01.util.creation.TriangleCreator;
import by.epam.dmitriysedin.task01.util.creation.TwoDimensionsPointCreator;
import by.epam.dmitriysedin.task01.util.parse.StringParser;
import by.epam.dmitriysedin.task01.util.read.ReadFromFile;
import by.epam.dmitriysedin.task01.util.validation.LineValidation;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TriangleInitFromFile {

    public static Triangle[] initFromFile(String fileName) throws EmptyFileException,
            ReadFromFileException, FileNotExistsException, TypeOfFileException{

        String[] paramOfTriangle = ReadFromFile.readFromFile(fileName);

        List<Triangle> triangles = new ArrayList<>();

        for(int i = 0; i < paramOfTriangle.length; i++){

            String line = paramOfTriangle[i];

            TwoDimensionsPoint apexA = TwoDimensionsPointCreator.create();
            TwoDimensionsPoint apexB = TwoDimensionsPointCreator.create();
            TwoDimensionsPoint apexC = TwoDimensionsPointCreator.create();
            Triangle triangle = TriangleCreator.create();

            if(LineValidation.getLineValidation(line)){

                String[] valueOfPoints = StringParser.parse(line);

                TwoDimensionsPointInit.init(apexA, Double.parseDouble(valueOfPoints[0]),
                        Double.parseDouble(valueOfPoints[1]));

                TwoDimensionsPointInit.init(apexB, Double.parseDouble(valueOfPoints[2]),
                        Double.parseDouble(valueOfPoints[3]));

                TwoDimensionsPointInit.init(apexC, Double.parseDouble(valueOfPoints[4]),
                        Double.parseDouble(valueOfPoints[5]));
            }
            TriangleInit.init(triangle, apexA, apexB, apexC);

            triangles.add(triangle);
        }

        Triangle[] trianglesArr = new Triangle[triangles.size()];

        return triangles.toArray(trianglesArr);
    }
}
