package banking;

public class TestBanking {
    public static void main(String[] args) {
        Account account = new Account(500.00);
        double firstWD = 150.00;
        double deposit = 22.50;
        double secondWD = 47.62;

        StringBuilder sb = new StringBuilder();
        sb.append("Create an account with a " + account.getAccount() + " balance." + System.getProperty("line.separator"));

        sb.append("Withdraw " + firstWD + System.getProperty("line.separator"));
        account.withdraw(firstWD);

        sb.append("Deposit " + deposit + System.getProperty("line.separator"));
        account.deposit(deposit);

        sb.append("Withdraw " + secondWD + System.getProperty("line.separator"));
        account.withdraw(secondWD);

        sb.append("The account balance is  " + account.getAccount());

        System.out.println(sb.toString());
        // test power sign
        AccountTest at = new AccountTest();
        at.pro = 2;
        at.def = 3;
    }
}
