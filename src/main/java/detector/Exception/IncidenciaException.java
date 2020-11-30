package detector.Exception;


public class IncidenciaException extends Exception{
    private static final long serialVersionUID = 1L;
    public String message;

    public IncidenciaException (String message){
        this.message = message;
    }

    public String getString(){
        return this.message;
    }
}