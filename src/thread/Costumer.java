package thread;

public class Costumer implements Runnable {
    private int buyNum;

    public Costumer() {
        this.buyNum = 1;
    }

    public Costumer(int buyNum) {
        this.buyNum = buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public void buy(int num) {
        Clerk cl = new Clerk();
        try {
            cl.sellProduct(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        buy(buyNum);
    }
}
