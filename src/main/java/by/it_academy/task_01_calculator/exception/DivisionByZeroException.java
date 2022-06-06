package by.it_academy.task_01_calculator.exception;

public class DivisionByZeroException extends Exception {
    private String reasonMsg;

    public DivisionByZeroException(String message) {
        this.reasonMsg = message;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + reasonMsg;
    }
}
