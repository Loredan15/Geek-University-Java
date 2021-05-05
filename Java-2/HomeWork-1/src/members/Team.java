package members;

public class Team {
    private String name;
    private Human member1;
    private Human member2;
    private Robot member3;
    private Cat member4;


    public Team(String name, Human member1, Human member2, Robot member3, Cat member4) {
        this.name = name;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
    }

    public Human getMember1() {
        return member1;
    }

    public Human getMember2() {
        return member2;
    }

    public Robot getMember3() {
        return member3;
    }

    public Cat getMember4() {
        return member4;
    }

    public void teamInfo(){

        System.out.println( "Команда " + name + ":" + "\n" +
                            "Участинк № 1 - " + member1.getClass().getSimpleName()  + " по имени " + member1.getName() + "\n" +
                            "Участинк № 2 - " + member2.getClass().getSimpleName() + " по имени " + member2.getName() + "\n" +
                            "Участинк № 3 - " + member3.getClass().getSimpleName() + " по имени " + member3.getName() + "\n" +
                            "Участинк № 4 - " + member4.getClass().getSimpleName() + " по имени " + member4.getName() + "\n");
    }

    public void isFinish(){
        System.out.println("\n" +
                member1.getName() + " прошел ли все испытания - " + member1.isFinish() + "\n" +
                member2.getName() + " прошел ли все испытания - " + member2.isFinish() + "\n" +
                member3.getName() + " прошел ли все испытания - " + member3.isFinish() + "\n" +
                member4.getName() + " прошел ли все испытания - " + member4.isFinish() + "\n");
    };


}
