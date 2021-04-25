public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate p) {
        if(p.decreaseFood(appetite)){
            this.satiety = true;
        }
    }

    public void isCatHungry(){
        if(satiety == true){
            System.out.println(this.name + " наелся и довольно мурчит");
        }else{
            System.out.println(this.name + " остался голодный, его аппетит " + this.appetite);
        }
    }
}
