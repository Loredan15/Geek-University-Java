/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */

import Exception.*;

public class HomeWork2 {

    public static void main(String[] args) {

        String[][] arr1 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr2 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4", "5"}};
        String[][] arr3 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "data"}};

        array4x4(arr1);

        try {
            array4x4(arr2);
        } catch (MySizeArrayException e) {
            e.printStackTrace();
        }

        try {
            array4x4(arr3);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void array4x4(String[][] arr) {
        int ARRAY_SIZE = 4;
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j >= ARRAY_SIZE || i >= ARRAY_SIZE) {
                    throw new MySizeArrayException(ARRAY_SIZE, ARRAY_SIZE, arr.length, arr[i].length);
                }
                try {
                    sumArr += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма чисел массива: " + sumArr);
    }
}
