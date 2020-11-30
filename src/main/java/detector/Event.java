package detector;
import detector.Exception.IncidenciaException;
import detector.Data.Attributes.*;

import java.util.HashMap;

public class Event {
    public JsonPath path;
    public country country;
    public installation installation;
    public device device;
    public type type;
    public medium medium;
    public battery battery;
    public location location;
    public timeStamp timeStamp;
    public sensorValue sensorValue;
    public cause cause;

    public Event(String filePath) throws IncidenciaException{
        EventsParser myParser = new EventsParser();
        HashMap<String,String> items = null;
        
        try {
            items = myParser.parse(filePath);
        } catch(IncidenciaException e) {
            throw new IncidenciaException("Error: file could not be readed because of bad representation.");
        }

        try {
            this.path = new JsonPath(filePath);
            this.country = new country(items.get(EventsParser.COUNTRY));
            this.installation = new installation(items.get(EventsParser.INSTALLATION));
            this.device = new device(items.get(EventsParser.DEVICE));
            this.type = new type(items.get(EventsParser.TYPE));
            this.medium = new medium(items.get(EventsParser.MEDIUM));
            this.battery = new battery(items.get(EventsParser.BATTERY));
            this.location = new location(items.get(EventsParser.LOCATION));
            this.timeStamp = new timeStamp(items.get(EventsParser.TIMESTAMP));
            this.sensorValue = new sensorValue(items.get(EventsParser.SENSORVALUE));
            this.cause = new cause("undefined");
        } catch (Exception e) {
            throw new IncidenciaException("Error: event could not be created because of bad atributtes.");
        }
        
    }

    public void setCause(String cause){
        this.cause.setValue(cause);
    }
}