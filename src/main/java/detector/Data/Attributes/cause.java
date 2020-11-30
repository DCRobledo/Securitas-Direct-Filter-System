package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class cause extends Attribute{
    public cause(String Value) throws IncidenciaException{
        this.pattern = "([A-Za-z0-9]\\s{1,})";
        this.errorMessage = "Error: invalid cause in Event";
        this.value = validate(Value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    
}
