/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */

public class HomeWork6 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Кузя");

        dog1.run(100);
        dog2.run(600);
        dog1.swim(5);

        cat1.run(50);
        cat2.run(200);
        cat3.swim(10);

        System.out.println("\nВсего было создано животных: " + Animal.getCount());
        System.out.println("Из них, кошек - " + Cat.getCount());
        System.out.println("И собак - " + Dog.getCount());
    }
}
