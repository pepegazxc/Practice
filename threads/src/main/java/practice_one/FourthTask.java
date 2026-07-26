package practice_one;

public class FourthTask {
    public static void main(String[] args) throws InterruptedException {
        Runnable logger  = () -> {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Logging system metrics...");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Saving logs...");
                    break;
                }
            }
        };
        Thread thread = new Thread(logger);
        thread.start();
        Thread.sleep(15000);
        thread.interrupt();

    }
}
