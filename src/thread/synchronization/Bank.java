package thread.synchronization;

import java.util.Arrays;

public class Bank {
    protected final double[] accounts;

    /**
     * set up accounts with same balance
     *
     * @param accountNum  the number of accounts
     * @param initBalance the balance in every account
     */
    public Bank(int accountNum, double initBalance) {
        accounts = new double[accountNum];
        Arrays.fill(accounts, initBalance);
    }

    public Bank(double[] accounts) {
        this.accounts = accounts;
    }

    public void transfer(int from, int to, double amount){
        if (amount > accounts[from]) return;
        System.out.println(Thread.currentThread());
        accounts[from] = accounts[from] - amount;
        System.out.printf(" %10.2f from %d to %d :", amount, from, to);
        accounts[to] = accounts[to] + amount;
        System.out.printf("Total balance : %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        return Arrays.stream(accounts).sum();
    }

    public int getSize() {
        return accounts.length;
    }
}
