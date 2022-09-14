package company.service.impl;

public class MyException extends RuntimeException{
    public MyException(String mess) {
        super(mess);
    }

    @Override
    public String toString() {
        return "MyException{" + getMessage() + "}";
    }
}
