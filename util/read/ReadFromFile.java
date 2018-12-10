package by.epam.dmitriysedin.task01.util.read;

import by.epam.dmitriysedin.task01.model.exception.EmptyFileException;
import by.epam.dmitriysedin.task01.model.exception.FileNotExistsException;
import by.epam.dmitriysedin.task01.model.exception.ReadFromFileException;
import by.epam.dmitriysedin.task01.model.exception.TypeOfFileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Dmitriy Sedin on 05.12.2018.
 */
public class ReadFromFile {

    public static String[] readFromFile(String fileName) throws ReadFromFileException,
            EmptyFileException, FileNotExistsException, TypeOfFileException{

        if(!new File(fileName).exists()){
            throw new FileNotExistsException("The file " + fileName + " does not exists.");
        }

        if(!new File(fileName).getName().contains(".txt")){
            throw new TypeOfFileException("The file " + fileName + " has not <txt> type.");
        }

        String[] linesFromFile = null;

        try(Stream<String> streamFromFile = Files.lines(Paths.get(fileName))){
            if(streamFromFile == null){
                throw new EmptyFileException("The file " + fileName + " is empty.");
            }
            linesFromFile = streamFromFile.toArray(String[]::new);
        } catch (IOException e){
            throw new ReadFromFileException("I/O Exception has occurred");
        }
        return linesFromFile;
    }
}
