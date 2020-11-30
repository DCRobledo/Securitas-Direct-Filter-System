package detector.Data.Attributes;

import java.util.regex.Pattern;
import detector.Exception.IncidenciaException;

public class Attribute {

    protected String value;
    protected String pattern;
    protected String errorMessage;

    protected String validate(String Value) throws IncidenciaException {
        Pattern pattern;
        pattern = Pattern.compile(this.pattern);
        if (!pattern.matcher(Value).matches()) {
            throw new IncidenciaException(this.errorMessage);
        }
        return value;
    }

    public String getValue() {
        return this.value;
    }
}
