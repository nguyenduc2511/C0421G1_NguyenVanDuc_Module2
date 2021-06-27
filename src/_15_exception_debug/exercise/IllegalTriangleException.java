package _15_exception_debug.exercise;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Tong 2 canh phai lon hon canh con lai vui long nhap lai ";
    }
}
