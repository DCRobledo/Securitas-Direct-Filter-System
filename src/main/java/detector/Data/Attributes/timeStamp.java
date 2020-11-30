package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class timeStamp extends Attribute{
    public timeStamp(String Value) throws IncidenciaException{
        this.pattern = "([0-9]{1,10})";
        this.errorMessage = "Error: invalid timestamp in Event";
        this.value = validate(Value);
    }
}
