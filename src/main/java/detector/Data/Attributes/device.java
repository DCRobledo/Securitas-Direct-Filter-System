package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class device extends Attribute{
    public device(String Value) throws IncidenciaException{
        this.pattern = "([1-5]{1})";
        this.errorMessage = "Error: invalid device in Event";
        this.value = validate(Value);
    }
}
