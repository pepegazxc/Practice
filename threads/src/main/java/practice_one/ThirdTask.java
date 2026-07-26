package practice_one;

import java.util.Random;

public class ThirdTask {
    private static int max1, max2, max3, max4;

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new Random().ints(100, 1, 1001).toArray();

        Thread t1 = new Thread(() -> max1 = findMax(arr, 0, 25));
        Thread t2 = new Thread(() -> max2 = findMax(arr, 25, 50));
        Thread t3 = new Thread(() -> max3 = findMax(arr, 50, 75));
        Thread t4 = new Thread(() -> max4 = findMax(arr, 75, 100));

        t1.start(); t2.start(); t3.start(); t4.start();

        t1.join(); t2.join(); t3.join(); t4.join();

        int result = Math.max(Math.max(max1, max2), Math.max(max3, max4));
        System.out.println("The biggest number: " + result);
    }

    private static int findMax(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start; i < end; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
