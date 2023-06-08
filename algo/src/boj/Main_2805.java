package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lowestN = 0;
        int biggestN = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeNum = Integer.parseInt(st.nextToken());
        int meters = Integer.parseInt(st.nextToken());

        int[] arr = new int[treeNum];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < treeNum; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;

            if (temp >= biggestN) {
                biggestN = temp;
            }
        }

        while (lowestN + 1 < biggestN) {
            int mid = (lowestN + biggestN) / 2;

            long curM = 0;
            for (int i : arr) {
                if (i > mid) {
                    curM += (i - mid);
                }
            }

            if (curM >= meters) {
                lowestN = mid;
            } else {
                biggestN = mid;
            }

        }

        System.out.println(lowestN);

    }
}
