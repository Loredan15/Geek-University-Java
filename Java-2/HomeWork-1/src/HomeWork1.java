/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

ПО ЖЕЛАНИЮ и при наличии большого запаса времени
5*. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников
(т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию,
метод вывода информации обо всех членах команды.
6*. Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий,
метод который будет просить команду пройти всю полосу;

 */

import barriers.*;
import members.*;

public class HomeWork1 {

    public static void main(String[] args) {
        Team team = new Team("Dream team",
                new Human("Петька", 1500, 4),
                new Human("Василий Иваныч", 800, 3),
                new Robot("Электроник", 2500, 1),
                new Cat("Мурзик", 1800, 5));
        team.teamInfo();

        Course course = new Course(new Wall(3), new Treadmill(1600));
        course.start(team);
        team.isFinish();
    }
}
