package boj;

import java.util.Scanner;

public class Main_13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
        }

        int headDir = sc.nextInt();
        int viceDir = sc.nextInt();

        long totDir = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];

            temp -= headDir;
            totDir++;

            if (temp > 0) {
                if (temp % viceDir == 0) {
                    totDir += temp / viceDir;
                } else
                    totDir += temp / viceDir + 1;
            }
        }

        System.out.println(totDir);

    }
}
