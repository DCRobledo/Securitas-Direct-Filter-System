package detector;
import detector.Exception.IncidenciaException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    //lectura del fichero
    public String getStringFromFile(String inputFile) throws IncidenciaException{
        BufferedReader reader;
        String fileContents ="";
        
        try{
            reader = new BufferedReader(new FileReader(inputFile));

        } catch (FileNotFoundException e){
            throw new IncidenciaException ("Error: Input file not found.");
        }

        String line;
        try {
            while ((line = reader.readLine()) != null){
                fileContents += line;
            }
        }catch(IOException e){
            throw new IncidenciaException("Error: input file could not be accessed");
        }

        try{
            reader.close();
        } catch (IOException e) {
            throw new IncidenciaException("Error: input file could not be closed.");
        }
        
        return fileContents;
    }
}
