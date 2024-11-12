import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            find(i);
        }

        System.out.println(max);
    }

    static void find(int idx) {

        if(idx==0){
            dp[idx] = arr[idx];
        }
        if(dp[idx] == Integer.MAX_VALUE){
            dp[idx] = Math.max(arr[idx],dp[idx-1]+arr[idx]);
        }

        max = Math.max(max,dp[idx]);
    }
}