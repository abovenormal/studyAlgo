package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cityArr = new int[n];
        int minB = 1;
        int maxB = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long budget = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            cityArr[i] = Integer.parseInt(st.nextToken());
            maxB = Math.max(cityArr[i], maxB);
        }
        int answer = 0;

        while (minB <= maxB) {
            long sum = 0;
            int midB = (minB + maxB) / 2;

            for (int i = 0; i < n; i++) {
                if (midB >= cityArr[i]) {
                    sum += cityArr[i];
                } else {
                    sum += midB;
                }
            }

            if (sum > budget) {
                maxB = midB - 1;
            } else {
                minB = midB + 1;
                answer = Math.max(answer, midB);
            }
        }

        System.out.println(answer);

    }
}
