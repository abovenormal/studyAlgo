package boj;

import java.io.*;

public class Main_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int coin5 = input / 5;
        int ans5 ;
        int coin2;
        int minN = Integer.MAX_VALUE;

        for (int i = coin5; i >= 0; i--) {

            int curCoin = input - (5 * i);

            if (curCoin % 2 == 0) {
                coin2 = curCoin / 2;
                ans5 = i;
                minN = Math.min(minN, (ans5 + coin2));
            }

        }

        if (minN == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minN);



    }
}
