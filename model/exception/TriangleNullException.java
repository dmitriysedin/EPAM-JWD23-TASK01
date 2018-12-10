package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 09.12.2018.
 */
public class TriangleNullException extends Exception {

    public TriangleNullException(String message) {
        super(message);
    }

    public TriangleNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNullException(Throwable cause) {
        super(cause);
    }

    public TriangleNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TriangleNullException() {
    }
}
