package thread;

public class Clerk {
    private volatile int product;
    private int maxNum = 20;
    private Productor productor = null;

    public Clerk() {
        this.product = maxNum;
        this.productor = new Productor();
    }

    public Clerk(int product) {
        this.product = product;
        this.productor = new Productor();
    }

    public Clerk(int product, int defineNum) {
        this.product = product;
        this.maxNum = defineNum;
        this.productor = new Productor();
    }

    public int getProduct() {
        return product;
    }

    public void addProduct() {
        addProduct(maxNum);
    }

    public synchronized void addProduct(int num) {
        //store is not big enough
        if (maxNum < product + num) {
            if (productor.product(maxNum - product)) {
                product = maxNum;
            } else {
                System.out.println("生產失敗");
            }
            return;
        }

        boolean isProduct = false;
        if (isProduct) {
            product = product + num;
        }
    }

    public void sellProduct(int num) throws Exception {
        if (num <= 0) {
            throw new Exception("无法销售小于0的产品");
        }
        synchronized (this) {
            if (product == 0) {
                System.out.println("the product is zero, please wait");
                addProduct();
            } else if (product < num) {
                System.out.println("the product is not enough, start product, please wait");
                addProduct(product - num);
                System.out.println("product arrive!");
                sellProduct(num);
            } else {
                product = product - num;
                System.out.println("product has sold!");
            }
        }
    }

}
