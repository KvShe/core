package gb.core.homework.custom_exceptions;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;

    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    @Override
    public String getMessage() {
        return "в ячейке: [" + i + ", " + j + "] содержатся данные, которые не удаётся преобразовать в указанный формат";
    }
}
