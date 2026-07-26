package practice_one;

public class SecondTask {
    static class BankAccount{
        private int bankAccount = 1000;

         synchronized void deposit(int amount){
            this.bankAccount += amount;
        }

         synchronized void withdraw(int amount){
            this.bankAccount -= amount;
        }

        public int getAccount(){
            return bankAccount;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable depositTask = () -> {
            for (int i = 0; i <= 100_000; i++){
                account.deposit(10);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i <= 100_000; i++){
                account.withdraw(10);
            }
        };

        Thread thread1 = new Thread(depositTask, "Depositor");
        Thread thread2 = new Thread(withdrawTask, "Withdrawer");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final bank account amount :" + account.bankAccount);
    }

}
