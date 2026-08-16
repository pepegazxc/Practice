package practice_two;

import java.util.concurrent.CountDownLatch;

public class ThirdTask {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(5);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task, "Worker-" + i);
            threads[i].start();
        }

        latch.await();
        System.out.println("All tasks completed");
    }
}
