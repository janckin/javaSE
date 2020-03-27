package array;

import java.util.Scanner;

public class TestScore {
    public static void main(String[] args) {
        System.out.println("please input students' number : ");
        Scanner number_sc = new Scanner(System.in);
        int length = number_sc.nextInt();
        int[] arr = new int[length];

        System.out.println("please input score : ");
        Scanner score_sc = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            arr[i] = score_sc.nextInt();
        }

        number_sc.close();
        score_sc.close();

        ScoreMothed score = new ScoreMothed(arr);
        score.publicScore();
    }

}

class ScoreMothed {
    int[] arr;

    public ScoreMothed() {

    }

    public ScoreMothed(int[] arr) {
        this.arr = arr;
    }

    public int getMax(int[] arr) {
        int max = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] >= max) {
                max = arr[j];
            }
        }
        return max;
    }

    public String getGrade(int score) {
        int max = getMax(arr);
        if (score >= max - 10) {
            return "A";
        } else if (max - 10 > score && score >= max - 20) {
            return "B";
        } else if (max - 20 > score && score >= max - 30) {
            return "C";
        } else {
            return "D";
        }
    }

    public void publicScore() {
        for (int j = 0; j < arr.length; j++) {
            System.out.println("Student " + j + " score is " + arr[j] + " grade is " + getGrade(arr[j]));
        }
    }

}