package Lesson5;
/*Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:
static final int SIZE = 10 000 000;
static final int HALF = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами.
3) Засекают время выполнения: long a = System.currentTimeMillis().
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis().
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
*/
public class HW5 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    private static void createArray1(float[] array){
        long start = System.currentTimeMillis();
        for(int i = 0; i < SIZE;i++){
            array[i] = 1;
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения 1 метода: " + (end - start));
    }

    private static void createArray2(float[] array) throws InterruptedException{
        long start = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(array,0,a1,0,HALF);
        System.arraycopy(array,HALF,a2,0,HALF);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < HALF;i++){
                    a1[i] = 1;
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < HALF;i++){
                    a2[i] = 1;
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(a1,0,array,0,HALF);
        System.arraycopy(a2,0,array,HALF,HALF);

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения 2 метода: " + (end - start));

    }
    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[SIZE];

        createArray1(arr);
        createArray2(arr);

    }
}
