
public class Cat extends Animal implements runActions,swimActions{
    private int distanceToRun = 200;
    private String name;
    private static int count;


    public Cat(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int distance) {
        if (distance < distanceToRun){
            System.out.println(this.name + " пробежал " + distance + "м.");
        }else{
            System.out.println(this.name + " столько пробежать не может");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Котики плавать не умеют");
    }
}
