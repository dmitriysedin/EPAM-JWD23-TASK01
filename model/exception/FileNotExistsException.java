package by.epam.dmitriysedin.task01.model.exception;

/**
 * Created by Dmitriy Sedin on 06.12.2018.
 */
public class FileNotExistsException extends Exception{

    public FileNotExistsException(String message) {
        super(message);
    }

    public FileNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotExistsException(Throwable cause) {
        super(cause);
    }

    public FileNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileNotExistsException() {
    }
}
