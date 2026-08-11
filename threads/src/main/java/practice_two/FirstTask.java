package practice_two;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstTask {
    static class Cell {
        private final Queue<Integer> BUFFER = new ArrayDeque<>();
        private static Integer CAPACITY = 5;

        synchronized void put(int num) throws InterruptedException {
            while (BUFFER.size() == CAPACITY ) wait();
            BUFFER.add(num);
            System.out.println(Thread.currentThread().getName() + ": Put");
            notifyAll();
        }

        synchronized void take() throws InterruptedException {
            while (BUFFER.isEmpty()) wait();
            BUFFER.poll();
            System.out.println(Thread.currentThread().getName() + ": Take");
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Cell cell = new Cell();

        Runnable putter = () -> {
            try {
                for (int i = 0; i < 15; i++) cell.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable taker = () -> {
            try {
                for (int i = 0; i < 15; i++) cell.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread p = new Thread(putter, "Putter");
        Thread t = new Thread(taker, "Taker");
        p.start(); t.start();
        p.join(); t.join();
    }
}