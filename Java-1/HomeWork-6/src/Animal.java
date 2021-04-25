

public class Animal {

    private static int count;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
