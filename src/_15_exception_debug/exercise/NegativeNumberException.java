package _15_exception_debug.exercise;

public class NegativeNumberException extends Exception {

    public NegativeNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return " do dai phai la so duong >0 ";
    }

}
