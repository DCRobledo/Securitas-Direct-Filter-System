package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class JsonPath extends Attribute{
    public JsonPath(String Value) throws IncidenciaException{
        this.errorMessage = "Error: invalid JSON path in Event";
        this.value = validate(Value);
    }
}
