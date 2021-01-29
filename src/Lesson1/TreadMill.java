package Lesson1;

public class TreadMill implements Obstacle {
    private int length;

    public TreadMill(int length){
        this.length = length;
    }

    @Override
    public String toString() {
        return "\n************************\n" +
                "Беговая дорожка длиной " + length + " метров";
    }

    @Override
    public boolean createObstacle(Able a) {
        if (!(a instanceof CanRun)) {
            return false;
        } else {
            return ((CanRun)a).run(length);
        }
    }
}
