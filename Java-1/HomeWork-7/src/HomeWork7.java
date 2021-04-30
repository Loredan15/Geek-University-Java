/*
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать
из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

import java.util.ArrayList;
import java.util.List;

public class HomeWork7 {
    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        Plate plate = new Plate(100);
        catList.add(new Cat("Барсик", 5));
        catList.add(new Cat("Мурзик", 15));
        catList.add(new Cat("Кузя", 10));
        catList.add(new Cat("Черныш", 30));
        catList.add(new Cat("Васька", 45));

        plate.info();
        for (Cat cat: catList) {
            cat.eat(plate);
            cat.isCatHungry();
            plate.info();
        }
        //Накормим все-таки последнего котика
        plate.increaseFood(5);
        plate.info();
        catList.get(4).eat(plate);
        catList.get(4).isCatHungry();


    }
}

