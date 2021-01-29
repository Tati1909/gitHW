package Lesson1;

public class Robot implements CanJump, CanRun {
    private int maxheight = 3;
    private int maxlength = 5000;

    @Override
    public String toString() {
        return "Робот" ;
    }

    @Override
    public boolean run(int length) {
        boolean run = length <= maxlength;
        System.out.println(run?"Робот пробежал дистанцию":"Робот не смог пробежать дистанцию");
        return run;
    }

    @Override
    public boolean jump(int height) {
        boolean canJump = height <= maxheight;
        System.out.println(canJump?"Робот перепрыгнул стену":"Робот не смог перепрыгнуть  стену");
        return canJump;
    }
}
