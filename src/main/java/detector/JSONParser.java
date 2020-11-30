package detector;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import detector.Exception.IncidenciaException;

public class JSONParser {
    //primero debemos leer el fichero
    public Object parse(String inputFile) throws IncidenciaException {
		TextReader myReader = new TextReader();
		String fileContents = myReader.getStringFromFile(inputFile);

		return parseJSONFromString(fileContents);
    }
    
    public JsonObject parseJSONFromString(String fileContents) throws IncidenciaException {
		JsonObject jsonLicense = null;
		try(StringReader sr = new StringReader(fileContents)) {
			jsonLicense = Json.createReader(sr).readObject();
		} catch(Exception e) {
			throw new IncidenciaException("Error: JSON object cannot be created due to incorrect representation");
		}
		return jsonLicense;
	}
}
