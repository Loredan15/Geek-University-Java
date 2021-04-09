/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
каждая ячейка которого равна initialValue;
6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.

**Примеры:
checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
 */


import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {

        int[] testArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание 1: \nИзначальный массив:    " + Arrays.toString(testArray));
        replaceValue(testArray);
        System.out.println("После замены значений: " + Arrays.toString(testArray));

        System.out.println("Задание 2:");
        createArray();

        int[] testArray3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание 3: \nИзначальный массив:    " + Arrays.toString(testArray3));
        multiplicationValue(testArray3);
        System.out.println("После замены значений: " + Arrays.toString(testArray3));

        System.out.println("Задание 4:");
        diagonalValue(5);

        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(arrayOfValues(5, 101)));

        System.out.println("Задание 6:");
        int[] testArray6 = {1, 5, 3, 2, 11, -4, 5, 2, 4, 8, 9, 1};
        minMaxArray(testArray6);

        System.out.println("Задание 7:");
        int[] testArray7 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Переданный массив: " + Arrays.toString(testArray7));
        System.out.println("Есть ли индекс равновесия: " + checkBalanceArray(testArray7));

        System.out.println("Задание 8:");
        int[] testArray8 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Изчанальный массив:\n" + Arrays.toString(testArray8));
        System.out.println("Сдвинем вправо: \n" + Arrays.toString(shiftArray(testArray8, 3)));
        System.out.println("А теперь обновленный массив сдвинем слево: \n" + Arrays.toString(shiftArray(testArray8, -4)));

    }

    public static int[] replaceValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
                continue;
            }
            if (array[i] == 1) {
                array[i] = 0;
            }
        }
        return array;
    }

    public static void createArray() {
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static int[] multiplicationValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }


        return array;
    }

    public static void diagonalValue(int lenght) {
        int array[][] = new int[lenght][lenght];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || lenght - i - 1 == j) {
                    array[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static int[] arrayOfValues(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void minMaxArray(int[] array) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println("Переданный массив: " + Arrays.toString(array));
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    public static boolean checkBalanceArray(int[] array) {
        boolean balance = false;
        int leftSum;
        int rightSum;

        for (int i = 0; i < array.length; i++) {
            leftSum = 0;
            for (int j = i; j >= 0; j--) {
                leftSum += array[j];
            }
            rightSum = 0;
            for (int k = i + 1; k < array.length; k++) {
                rightSum += array[k];
            }
            if (leftSum == rightSum) {
                balance = true;
            }
        }

        return balance;
    }

    public static int[] shiftArray(int[] array, int shift) {
        int temp;

        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        }
        if (shift < 0) {
            for (int i = 0; i > shift; i--) {
                temp = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int j = 1; j < array.length - 1; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 2] = temp;
            }
        }
        return array;
    }
}


