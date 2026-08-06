package practice_two;

public class FirstTask {
    static class Cell {
        private boolean full = false;

        synchronized void put() throws InterruptedException {
            while (full) wait();
            full = true;
            System.out.println(Thread.currentThread().getName() + ": Put");
            notifyAll();
        }

        synchronized void take() throws InterruptedException {
            while (!full) wait();
            full = false;
            System.out.println(Thread.currentThread().getName() + ": Take");
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Cell cell = new Cell();

        Runnable putter = () -> {
            try {
                for (int i = 0; i < 5; i++) cell.put();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable taker = () -> {
            try {
                for (int i = 0; i < 5; i++) cell.take();
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