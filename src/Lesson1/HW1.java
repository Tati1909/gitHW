package Lesson1;

import java.lang.reflect.Array;

public class HW1 {
    public static void main(String[] args) {

        Able[] participants = {new Man(), new Cat(), new Robot()};
        Obstacle[] obstacles = {new Wall(1), new TreadMill(2000), new Wall(3)};

        for (Obstacle obst : obstacles) {
            System.out.println(obst);
            for (int i = 0; i < participants.length; i++) {
                if (participants[i] != null) {
                    boolean isSuccess = obst.createObstacle(participants[i]);
                    if (!isSuccess) {
                        participants[i] = null;
                    }
                }
            }
            System.out.print("Участники, которые остались:");
            printParticipants(participants);
        }
    }

    public static void printParticipants(Able[] participants) {
        for(Able partic : participants){
            if(partic != null){
                System.out.print(" " + partic);
            }
        }
    }

}
