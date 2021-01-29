package Lesson1;

public class Man implements CanJump, CanRun {
    private int maxheight = 2;
    private int maxlength = 2000;

    @Override
    public String toString() {
        return "Человек" ;
    }

    @Override
    public boolean run(int length) {
        boolean run = length <= maxlength;
        System.out.println(run?"Человек пробежал дистанцию":"Человек не смог пробежать дистанцию");
        return run;
    }

    @Override
    public boolean jump(int height) {
        boolean canJump = height <= maxheight;
        System.out.println(canJump?"Человек перепрыгнул стену":"Человек не смог перепрыгнуть  стену");
        return canJump;
    }
}
