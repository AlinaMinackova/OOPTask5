package exception;

public class IncorrectDurationException extends RuntimeException{
    public IncorrectDurationException(String message){
        super(message);
    }
}
