package boj;

import java.io.*;

public class Main_2293 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j = 1; j<k+1;j++){
                if(j>=coin[i]){
                    dp[j] += dp[j-coin[i]];
                }
            }
        }

        bw.write(dp[k]+"\n");
        bw.flush();

    }
}
