package Lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {

        String[][] dArr = new String[4][4];
        crossFill(dArr);
    }

    private static int crossFill(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер поданного массива не соответствует условию.");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[0].length !=4) {
                throw new MyArraySizeException("Размер поданного массива не соответствует условию.");
            }
            for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = "1";
                    array[0][0] = "Hello";
                    array[1][1] = "Good";
                    array[2][2] = "Hy";
                    try {
                       sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(" Невозможно преобразовать строку " + array[i][j] + " в число.\n");
                    }
            }
        }
        return sum;

    }
}
