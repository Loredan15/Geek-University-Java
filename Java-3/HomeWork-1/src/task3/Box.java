package task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> storage = new ArrayList<T>();

    public void addFruit(T fruit){
        storage.add(fruit);
    }

    public int getSizeBox(){
        return storage.size();
    }

    public float getWeight(){
        float boxWeight = 0;
        boxWeight = this.getSizeBox() * T.getFruitWeight();
        return boxWeight;
    }

    public boolean compare(Box box){
        return box.getWeight() == this.getWeight();
    }

    public void pourFruit(Box box){
        box.storage.addAll(this.storage);
        this.storage.clear();
    }
}
