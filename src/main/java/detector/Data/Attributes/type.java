package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class type extends Attribute {
    public type(String Value) throws IncidenciaException {
        this.errorMessage = "Error: invalid type in Event";
        this.value = this.validate(Value);
    }

    @Override
    protected String validate(String value) throws IncidenciaException {
        if (!(value.equalsIgnoreCase("SHOCK") || value.equalsIgnoreCase("SMOKE") || value.equalsIgnoreCase("WATER")
                || value.equalsIgnoreCase("INHIBITION") || value.equalsIgnoreCase("AIR"))) {
            throw new IncidenciaException(this.errorMessage);
        }
        return value;
    }
}