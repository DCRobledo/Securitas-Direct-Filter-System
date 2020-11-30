package detector.Data.Attributes;

import detector.Exception.IncidenciaException;

public class medium extends Attribute {
    public medium(String Value) throws IncidenciaException{
        this.pattern = "([“ADSL”,“GPRS”, “SMS”, “SIGFOX”])";
        this.errorMessage = "Error: invalid medium in Event";
        this.value = this.validate(Value);
    }

    @Override
    protected String validate (String value) throws IncidenciaException{
        if(!(value.equalsIgnoreCase("ADSL") || value.equalsIgnoreCase("GPRS") || value.equalsIgnoreCase("SMS")
        || value.equalsIgnoreCase("SIGFOX"))){
            throw new IncidenciaException(this.errorMessage);
        }
        return value;
    }
}
