package Java2Homework5;

public class Homework5 {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    public static void main(String[] args) throws InterruptedException {
        methodWithOneThread();
        methodWithTwoThreads();
    }
    static void methodWithOneThread(){
        for(int i = 0; i < size; i++){
            arr[i] = 1.0f;
        }
        long fillArray = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения цикла расчета в 1 потоке: " + (System.currentTimeMillis() - fillArray));
    }
    static void methodWithTwoThreads() throws InterruptedException {
        for(int i = 0; i < size; i++){
            arr[i] = 1.0f;
        }
        long fillArray = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //long time = System.currentTimeMillis() - fillArray; // время разделение массива

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j = h; j < size; i++, j++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        //long time2 = System.currentTimeMillis() - fillArray - time; // время расчета 2ух массивов
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        //long time3 = System.currentTimeMillis() - fillArray - time2; // время расчета склейки массивов
        long allTime = System.currentTimeMillis() - fillArray; // общее время расчета
        //System.out.println("Время выполнения разделения массива: " + time);
        //System.out.println("Время выполнения цикла расчета для 2 массива: " + time2);
        //System.out.println("Время склеивания массивов: " + time3);
        System.out.println("Время выполнения цикла расчета в 2ух потоках: " + allTime);
    }
}
