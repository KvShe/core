package gb.core.homework;

import gb.core.homework.custom_exceptions.MyArrayDataException;
import gb.core.homework.custom_exceptions.MyArraySizeException;

/**
 * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class Main {
    private static String[][] numbers = {
            {"0", "1", "2", "3"},
            {"4", "5", "6", "7"},
            {"8", "9", "10", "11"},
            {"12", "13", "14", "15"},
    };

    public static void main(String[] args) {
        try {
            System.out.println("sum = " + sum(numbers));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int sum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkLength(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
            }
        }

        return sum;
    }

    private static void checkLength(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("size array not: 4 x 4", array);
        }

        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("size array not: 4 x 4", array);
            }
        }
    }
}
