public class Dog extends Animal implements runActions, swimActions{
    private String name;
    private static int count;
    private int distanceToRun = 500;
    private int distanceToSwim = 10;

    public Dog(String name) {
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
        }else {
            System.out.println(this.name + " столько пробежать не может");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < distanceToSwim){
            System.out.println(this.name + " проплыл " + distance + "м.");
        }else{
            System.out.println(this.name + " столько проплыть не может");
        }
    }
}
