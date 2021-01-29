package Lesson1;

public class Cat implements CanJump, CanRun {
    private int maxheight = 1;
    private int maxlength = 500;

    @Override
    public String toString() {
        return "Кот" ;
    }

    @Override
    public boolean run(int length) {
        boolean canRun = length <= maxlength;
        System.out.println(canRun?"Кот пробежал дистанцию":"Кот не смог пробежать дистанцию");
        return canRun;
    }

    @Override
    public boolean jump(int height) {
        boolean canJump = height <= maxheight;
        System.out.println(canJump?"Кот перепрыгнул стену":"Кот не смог перепрыгнуть  стену");
        return canJump;
    }
}
