package members;

import barriers.Treadmill;
import interfaces.RunAction;
import interfaces.JumpAction;

public class Human implements JumpAction, RunAction {

    private final int runDistance = 500;
    private final int jumpHeight = 3;



    @Override
    public void jump() {

    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getLength() < jumpHeight){
            System.out.println("Стена покорена");
        }else {
            System.out.println("Cтена не взята");
        }
    }
}
