package barriers;

import members.Team;

public class Course {
    private Wall barrier1;
    private Treadmill barrier2;



    public Course(Wall barrier1, Treadmill barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;

    }

    public void start(Team team){
        System.out.println("Испытание № 1:");
        team.getMember1().jump(barrier1);
        team.getMember2().jump(barrier1);
        team.getMember3().jump(barrier1);
        team.getMember4().jump(barrier1);

        System.out.println("Испытание № 2:");
        if(team.getMember1().isFinish()) team.getMember1().run(barrier2);
        if(team.getMember2().isFinish()) team.getMember2().run(barrier2);
        if(team.getMember3().isFinish()) team.getMember3().run(barrier2);
        if(team.getMember4().isFinish()) team.getMember4().run(barrier2);
    }
}
