package practice_two;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SecondTask {
    static class SyncCounter{
        private int counter;

        public synchronized void count(){
            counter += 1;
        }

        public int getCounter(){
            return this.counter;
        }

        public static void main(String[] args) throws InterruptedException {
            SyncCounter syncCounter = new SyncCounter();


            Runnable task = () ->{
                for (int i = 0 ; i < 1_000_000; i++){
                    syncCounter.count();
                }
            };

            long start = System.nanoTime();
            Thread[] threads = new Thread[10];
            for (int i = 0; i < threads.length; i ++){
                threads[i] = new Thread(task, "Counter");
                threads[i].start();
            }

            for (Thread thread : threads){
                thread.join();
            }

            long end = System.nanoTime();

            System.out.println("Result: " + syncCounter.getCounter() + ", time: " + (end - start) / 1_000_000 + " ms");
        }
    }

    static class AtomicCounter{
        private AtomicInteger counter = new AtomicInteger(0);

        public void count(){
            counter.incrementAndGet();
        }

        public AtomicInteger getCounter(){
            return this.counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();


        Runnable task = () ->{
            for (int i = 0 ; i < 1_000_000; i++){
                atomicCounter.count();
            }
        };

        long start = System.nanoTime();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i ++){
            threads[i] = new Thread(task, "Counter");
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        long end = System.nanoTime();

        System.out.println("Result: " + atomicCounter.getCounter() + ", time: " + (end - start) / 1_000_000 + " ms");
    }

    static class ReentranCounter {
        ReentrantLock lock = new ReentrantLock();

        private int counter;

        public void count(){
            lock.lock();
            try {
                counter += 1;
            }finally {
                lock.unlock();
            }

        }

        public int getCounter(){
            return this.counter;
        }

        public static void main(String[] args) throws InterruptedException {
            ReentranCounter reentranCounter = new ReentranCounter();


            Runnable task = () ->{
                for (int i = 0 ; i < 1_000_000; i++){
                    reentranCounter.count();
                }
            };

            long start = System.nanoTime();
            Thread[] threads = new Thread[10];
            for (int i = 0; i < threads.length; i ++){
                threads[i] = new Thread(task, "Counter");
                threads[i].start();
            }

            for (Thread thread : threads){
                thread.join();
            }

            long end = System.nanoTime();

            System.out.println("Result: " + reentranCounter.getCounter() + ", time: " + (end - start) / 1_000_000 + " ms");
        }
    }
}
