package by.epam.dmitriysedin.task01.util.initialization;

import by.epam.dmitriysedin.task01.model.entity.TwoDimensionsPoint;


/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class TwoDimensionsPointInit {

    public static void init(TwoDimensionsPoint point, double abscissa, double ordinate){

        point.setAbscissa(abscissa);
        point.setOrdinate(ordinate);
    }
}
