/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.

Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

 */

public class HomeWork5 {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван", "Директор", "ivanov@gmail.com", "+79991234567", 50, 1_000_000);
        persArray[1] = new Person("Петров Петр", "Зам.директора", "petrov@gmail.com", "+79997654321", 45, 500_000);
        persArray[2] = new Person("Сидоров Евгений", "Исполнительный директор", "sidorov@gmail.com", "+79991236547", 42, 300_000);
        persArray[3] = new Person("Пупкин Сергей", "Технический директор", "pupkin@gmail.com", "+799998745216", 41, 100_000);
        persArray[4] = new Person("Просто Вася", "Работяга", "vasya@gmail.com", "+7991231234", 30, 20_000);

        for (Person pers: persArray) {
            if(pers.age >= 40) {
                System.out.println(pers);
            }
        }
    }
}
