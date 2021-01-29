package Lesson1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "\n************************\n" +
                "Стена высотой " + height + " метра";
    }

    @Override
    public boolean createObstacle(Able a) {
        if (!(a instanceof CanJump)) {
            return false;
        } else {
            return ((CanJump)a).jump(height);
        }
    }


}
