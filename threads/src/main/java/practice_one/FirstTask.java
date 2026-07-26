package practice_one;

import java.util.Random;

public class FirstTask {
    public static void main(String[] args){
        Random random = new Random();

        Runnable task = () -> {
            try {
                printTheNumbers();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Current thread " + Thread.currentThread().getName() + " was interrupted");
            }
        };

        Thread thread1 = new Thread(task, "Printer A");
        Thread thread2 = new Thread(task, "Printer B");
        Thread thread3 = new Thread(task, "Printer C");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void printTheNumbers() throws InterruptedException {
        for (int i = 1; i <=5; i++){
            System.out.println("Thread name : " + Thread.currentThread().getName() + "; Numbers 1 to 5 : " + i);
            Thread.sleep(100);
        }
    }
}
