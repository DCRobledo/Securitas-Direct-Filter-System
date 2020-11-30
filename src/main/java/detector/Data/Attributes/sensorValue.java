package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class sensorValue extends Attribute{
    public sensorValue(String Value) throws IncidenciaException{
        this.pattern = "([0-100]{1,3})";
        this.errorMessage = "Error: invalid sensor value in Event";
        this.value = validate(Value);
    }
}
