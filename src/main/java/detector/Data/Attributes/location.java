package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class location extends Attribute{
    public location(String Value) throws IncidenciaException{
        this.errorMessage = "Error: invalid location in Event";
        this.value = this.validate(Value);
    }

    @Override
    protected String validate (String value) throws IncidenciaException{
        if(!(value.equalsIgnoreCase("SALON") || value.equalsIgnoreCase("VENTANA") || value.equalsIgnoreCase("PUERTA")
        || value.equalsIgnoreCase("COCINA") || value.equalsIgnoreCase("HABITACIÓN") || value.equalsIgnoreCase("GARAJE")
        || value.equalsIgnoreCase("SOTANO") || value.equalsIgnoreCase("BAÑO"))){
            throw new IncidenciaException(this.errorMessage);
        }
        return value;
    }
}
