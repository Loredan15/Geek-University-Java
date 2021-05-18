public class HomeWork5 {
    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1() {
        final int size = 10000000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.print("Время выполнения метода в один поток: ");
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void method2() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long t1 = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        System.out.print("Время выполнения разделения на 2 массива: ");
        System.out.println(System.currentTimeMillis() - t1);

        Thread thread1 = new Thread(() ->{
            long t2 = System.currentTimeMillis();
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.print("Время выполнения первого потока: ");
            System.out.println(System.currentTimeMillis() - t2);
        });

        Thread thread2 = new Thread(() ->{
            long t3 = System.currentTimeMillis();
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.print("Время выполнения второго потока: ");
            System.out.println(System.currentTimeMillis() - t3);
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long t4 = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.print("Время выполнения обратной склейки массивов: ");
        System.out.println(System.currentTimeMillis() - t4);


        System.out.print("Общее время выполнение метода в 2 потока: ");
        System.out.println(System.currentTimeMillis() - t1);
    }
}
