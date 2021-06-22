import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println(" >>> Подготовка <<<");
        CyclicBarrier startCyclicBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println(">>> Гонка началась <<<"));
        CyclicBarrier finishCyclicBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println(">>> Гонка закончилась <<<"));

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(startCyclicBarrier,finishCyclicBarrier, race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}
