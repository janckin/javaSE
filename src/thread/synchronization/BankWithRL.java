package thread.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankWithRL extends Bank {

    private Lock bankLock = new ReentrantLock();

    public BankWithRL(int accountNum, double initBalance) {
        super(accountNum, initBalance);
    }

    @Override
    public void transfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            if (amount > accounts[from]) throw new RuntimeException();
            System.out.println(Thread.currentThread());
            accounts[from] = accounts[from] - amount;
            System.out.printf(" %10.2f from %d to %d :", amount, from, to);
            accounts[to] = accounts[to] + amount;
            System.out.printf("Total balance : %10.2f%n", getTotalBalance());
        } catch (RuntimeException e){
            System.out.println(from + " is empty");
        }finally {
            bankLock.unlock();
        }
    }

}
