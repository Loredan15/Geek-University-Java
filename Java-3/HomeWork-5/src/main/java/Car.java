import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CyclicBarrier startCyclicBarrier;
    private CyclicBarrier finishCyclicBarrier;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CyclicBarrier startCyclicBarrier, CyclicBarrier finishCyclicBarrier, Race race, int speed) {
        this.startCyclicBarrier = startCyclicBarrier;
        this.finishCyclicBarrier = finishCyclicBarrier;
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + CARS_COUNT;
        CARS_COUNT++;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            startCyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            finishCyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
