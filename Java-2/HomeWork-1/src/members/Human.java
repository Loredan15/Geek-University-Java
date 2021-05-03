package members;

import barriers.Treadmill;
import barriers.Wall;
import interfaces.RunAction;
import interfaces.JumpAction;

public class Human implements JumpAction, RunAction {

    private String name;
    private int runDistance;
    private int jumpHeight;

    public Human(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean jump(Wall wall) {
        if(wall.getHeight() < jumpHeight){
            System.out.println(this.getName() + " покорил стену");
            return true;
        }else{
            System.out.println(this.getName() + " не смог покорить стену");
            return false;
        }

    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (treadmill.getLength() < runDistance){
            System.out.println(this.getName() + " успешно пробежал");
            return true;
        }else {
            System.out.println(this.getName() + "не смог пробежать");
            return false;
        }
    }
}
