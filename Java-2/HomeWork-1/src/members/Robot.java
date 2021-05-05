package members;

import barriers.Treadmill;
import barriers.Wall;
import interfaces.JumpAction;
import interfaces.RunAction;

public class Robot implements RunAction, JumpAction {
    private String name;
    private int runDistance;
    private int jumpHeight;
    private boolean finish;

    public Robot(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public boolean isFinish() {
        return finish;
    }

    @Override
    public void jump(Wall wall) {
        if(wall.getHeight() <= jumpHeight){
            System.out.println(this.getName() + " покорил стену");
            finish = true;
        }else{
            System.out.println(this.getName() + " не смог покорить стену");
            finish = false;
        }

    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getLength() <= runDistance){
            System.out.println(this.getName() + " успешно пробежал");
            finish = true;
        }else {
            System.out.println(this.getName() + "не смог пробежать");
            finish = false;
        }
    }
}
