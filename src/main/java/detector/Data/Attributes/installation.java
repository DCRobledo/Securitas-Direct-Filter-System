package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class installation extends Attribute{
    public installation(String Value) throws IncidenciaException{
        this.pattern = "([1-9]{1,10})";
        this.errorMessage ="Error: invalid installation in Event";
        this.value = validate(Value);
    }
}
