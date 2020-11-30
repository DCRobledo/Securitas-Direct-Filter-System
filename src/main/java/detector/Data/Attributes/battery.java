package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class battery extends Attribute{
    public battery(String Value) throws IncidenciaException{
        this.errorMessage = "Error: invalid battery in Event";
        this.value = this.validate(Value);
    }
    @Override
    protected String validate (String value) throws IncidenciaException{
        if(!(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))){
            throw new IncidenciaException(this.errorMessage);
        }
        return value;
    }
}
