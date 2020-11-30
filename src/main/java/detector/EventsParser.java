package detector;

import java.util.HashMap;
import javax.json.JsonObject;
import detector.Exception.IncidenciaException;

public class EventsParser extends JSONParser {
    private static final String ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE = "Error: invalid input data in JSON structure";
    public static final String COUNTRY = "country";
    public static final String INSTALLATION = "installation";
    public static final String DEVICE = "device";
    public static final String TYPE = "type";
    public static final String MEDIUM = "medium";
    public static final String BATTERY = "battery";
    public static final String LOCATION = "location";
    public static final String TIMESTAMP = "timestamp";
    public static final String SENSORVALUE = "sensorvalue";

    public HashMap<String, String> parse (String FileName) throws IncidenciaException{
        JsonObject myJSON = (JsonObject) super.parse(FileName);
        HashMap<String,String> items = new HashMap<String,String>();

    
        try{
            items.put(COUNTRY, myJSON.getString(COUNTRY));
            items.put(INSTALLATION, myJSON.getString(INSTALLATION));
            items.put(DEVICE, myJSON.getString(DEVICE));
            items.put(TYPE, myJSON.getString(TYPE));
            items.put(MEDIUM, myJSON.getString(MEDIUM));
            items.put(BATTERY, myJSON.getString(BATTERY));
            items.put(LOCATION, myJSON.getString(LOCATION));
            items.put(TIMESTAMP, myJSON.getString(TIMESTAMP));
            items.put(SENSORVALUE, myJSON.getString(SENSORVALUE));
        } catch (Exception pe){
            throw new IncidenciaException(ERROR_INVALID_INPUT_DATA_IN_JSON_STRUCTURE);
        }    
        return items;
    }

}
