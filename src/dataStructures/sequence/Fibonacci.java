package dataStructures.sequence;

/**
 * Fibonacci sequence
 *
 * @author lsy
 */
public class Fibonacci {
    /**
     * find element in index by recrusion
     *
     * @param n the index of number,start from 1
     * @return
     */
    public static int getElementByRec(int n) {
        /*
         *here can control about start from 1 or from 0
         * if start in 1 set f(1) = 1 ,f(2) =1
         * if start in 0 set f(0) = 1 , f(1) = 1
         *
         *in other words, the first if-else sentence set up the start index
         */
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n <= 0) {
            return 0;
        }
        return getElementByRec(n - 1) + getElementByRec(n - 2);
    }

    /**
     * find element in index by loop
     *
     * @param n the index of number,start from 1
     * @return
     */
    public static int getElement(int n) {
        int current = 0;
        int elementBig = 1;
        int element = 1;
        if (n <= 2) {
            return 1;
        }
        /*
         * this need to start in 2, because the before it is different.
         */
        for (int i = 2; i < n; i++) {
            current = elementBig + element;
            element = elementBig;
            elementBig = current;
        }
        return current;
    }

    /**
     * test of getElement
     * corrective sequence:
     * 1 1 2 3 5 8 13 21 34 55 89 144 233
     *
     * @param args
     */
    public static void main(String[] args) {
        //test recrusion
        System.out.println(getElementByRec(2));
        System.out.println(getElementByRec(6));
        System.out.println(getElementByRec(8));

        //test loop
        System.out.println(getElement(2));
        System.out.println(getElement(6));
        System.out.println(getElement(8));
    }
}
