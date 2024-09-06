package gb.core.homework.custom_exceptions;

public class MyArraySizeException extends Exception {
    private String[][] array;

    public MyArraySizeException(String message, String[][] array) {
        super(message);
    }
}
