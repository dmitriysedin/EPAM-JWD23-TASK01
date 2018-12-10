package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.Triangle;
import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TriangleInit {

    public static void init(Triangle triangle, TwoDimensionsPoint apexA, TwoDimensionsPoint apexB,
                            TwoDimensionsPoint apexC){

        triangle.setApexA(apexA);
        triangle.setApexB(apexB);
        triangle.setApexC(apexC);
    }
}
