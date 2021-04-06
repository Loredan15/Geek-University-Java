/*
1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
если да – вернуть true, в противном случае – false.
2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
если число отрицательное, и вернуть false если положительное.
4. Написать метод, которому в качестве аргументов передается строка и число,
метод должен отпечатать в консоль указанную строку, указанное количество раз;
5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (
високосный - true, не високосный - false). Каждый 4-й год является високосным,
кроме каждого 100-го, при этом каждый 400-й – високосный.

 */

public class HomeWork2 {

    public static void main(String[] args) {

        System.out.println("1.===============");
        System.out.println(SumFrom10To20(5, 4));
        System.out.println(SumFrom10To20(5, 5));
        System.out.println(SumFrom10To20(10, 10));
        System.out.println(SumFrom10To20(10, 11));

        System.out.println("2.===============");
        IsNumberPositive(-5);
        IsNumberPositive(0);
        IsNumberPositive(5);

        System.out.println("3.===============");
        System.out.println(NumberPositive(-10));
        System.out.println(NumberPositive(0));
        System.out.println(NumberPositive(10));

        System.out.println("4.===============");
        //Bart Simpson mod on
        PrintString("Я не забываю про знак равенства в проверке условия", 3);
        //Bart Simpson mod off

        System.out.println("5.===============");
        int[] years = {1758, 1867, 1977, 2000, 2020};
        for (int a: years) {
            isYearLeap(a);
        }
    }

    public static boolean SumFrom10To20(int a, int b){
        return (a + b >=10) && (a + b <= 20);
    }

    public static void IsNumberPositive(int number){
        if (number < 0){
            System.out.printf("Число %d является отрицательным\n", number);
        }else {
            System.out.printf("Число %d является положительным\n", number);
        }
    }

    public static boolean NumberPositive(int number){
        return number >= 0;
    }

    public static void PrintString(String string, int counter ){
        for(;counter >0; counter--){
            System.out.println(string);
        }
    }

    public static void isYearLeap(int year){
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            System.out.printf("Год %d является високосным\n", year);
        }else{
            System.out.printf("Год %d является не високосным\n", year);
        }
    }
}
