package thread;

public class Productor {
    //product
    public boolean product(int num) {
        if (num <= 0) {
            System.out.println("订单数必须大于0");
            return false;
        }
        return true;
    }
}
