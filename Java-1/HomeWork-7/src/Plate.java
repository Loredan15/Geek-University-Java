public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        boolean isSuccess = false;
        if(n <=food) {
            food -= n;
            isSuccess = true;
        }
        return isSuccess;
    }

    public void increaseFood(int n){
        food +=n;
        System.out.println("Добавити в тарелку немного еды: " + n);
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
