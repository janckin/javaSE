package thread.synchronization;

//this class shows the way to write synchronize
public class BankWithSyn extends Bank {
    public BankWithSyn(int accountNum, double initBalance) {
        super(accountNum, initBalance);
    }

    @Override
    public void transfer(int from, int to, double amount) {
        synchronized (BankWithSyn.class) {
            try {
                while (amount > accounts[from]) {
                    BankWithSyn.class.wait();
                }
                if (amount > accounts[from]) throw new RuntimeException("synchronized didn't work ");
                System.out.println(Thread.currentThread());
                accounts[from] = accounts[from] - amount;
                System.out.printf(" %10.2f from %d to %d :", amount, from, to);
                accounts[to] = accounts[to] + amount;
                System.out.printf("Total balance : %10.2f%n", getTotalBalance());
                BankWithSyn.class.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
