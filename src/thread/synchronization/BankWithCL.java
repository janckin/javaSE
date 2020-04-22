package thread.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* this class add a condition and develop a condition lock*/
public class BankWithCL extends Bank {

    private Condition sufficientFunds;
    private Lock bankLock;

    public BankWithCL(int accountNum, double initBalance) {
        super(accountNum, initBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    @Override
    public void transfer(int from, int to, double amount) {
        bankLock.lock();//get lock
        try {
            while (amount > accounts[from]) {
                sufficientFunds.await();// if from lacks money, wait and release the lock
            }
            if (amount > accounts[from]) throw new RuntimeException("the Condition is not work");//test
            System.out.println(Thread.currentThread());
            accounts[from] = accounts[from] - amount;
            System.out.printf(" %10.2f from %d to %d :", amount, from, to);
            accounts[to] = accounts[to] + amount;
            System.out.printf("Total balance : %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();// awake all threads
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

}
