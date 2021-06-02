import task3.Apple;
import task3.Box;
import task3.Orange;
import java.util.*;

public class HomeWork1 {
    public static void main(String[] args) {
        List<Integer> task1 = new ArrayList<>();
        task1.add(0, 1);
        task1.add(1, 2);
        switchArrayItem(task1);
        System.out.println(task1);

        Integer[] task2 = {1, 2, 3};
        ArrayList<?> convertTask2 = convertMasToArrayList(task2);
        System.out.println(convertTask2.getClass().getSimpleName());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        System.out.println("Первая коробка с апельсинами - " + orangeBox1.getWeight());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        orangeBox1.pourFruit(orangeBox2);
        System.out.println("Вторая коробка с апельсинами - " + orangeBox2.getWeight());
        System.out.println("Первая коробка после пересыпания - " + orangeBox1.getWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        System.out.println("Коробка с яблоками - " + appleBox.getWeight());

        System.out.println("Равен ли вес коробок ? - " + appleBox.compare(orangeBox1));
    }

    public static <T> T switchArrayItem(List<T> array) {
        if ((Objects.nonNull(array)) & (array.size() > 1)) {
            T temp = array.get(1);
            array.set(1, array.get(0));
            array.set(0, temp);
        }
        return (T) array;
    }

    public static <T> ArrayList<T> convertMasToArrayList(T mas) {
        ArrayList<T> result = new ArrayList<T>(Collections.unmodifiableList(Arrays.asList(mas)));
        return result;
    }
}
