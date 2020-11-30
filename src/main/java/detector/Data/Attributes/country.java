package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class country extends Attribute {
    public country(String Value) throws IncidenciaException {
        this.pattern = "([A-Z]{3})";
        this.errorMessage = "Error: invalid country in Event";
        this.value = validate(Value);
    }
}
