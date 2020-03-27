package mathKnowledge;

public class YangHuiTriangle {
    public static void main(String[] args) {

    }

    public static void createTriangle(int lineNum) {

        if (lineNum < 2) {

            return;
        }
        long[][] arr = new long[lineNum][];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;


        for (int i = 0; i < lineNum; i++) {
            arr[i] = new long[i + 1];


        }


    }
}
