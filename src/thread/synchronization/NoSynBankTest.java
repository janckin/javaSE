package thread.synchronization;

// this class show that bank in different thread without synchronizing the variable.
public class NoSynBankTest {
    public static final int ACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);
        BankWithRL bankWithRL = new BankWithRL(ACCOUNTS, INITIAL_BALANCE);
        BankWithCL bankWithCL = new BankWithCL(ACCOUNTS, INITIAL_BALANCE);
        BankWithSyn bankWithSyn = new BankWithSyn(ACCOUNTS, INITIAL_BALANCE);
        //testNoSynBank(bank);
        //testNoSynBank(bankWithRL);
        //testNoSynBank(bankWithCL);
        testNoSynBank(bankWithSyn);
    }

    @SuppressWarnings("all")
    public static void testNoSynBank(Bank bank) {
        for (int i = 0; i < ACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.getSize() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
