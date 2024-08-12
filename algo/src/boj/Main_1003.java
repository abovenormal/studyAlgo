import java.io.*;

public class Main {

    static int testCase, goal;
    static int[][] cnt = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());
        cnt[0][0] = 1;
        cnt[1][1] = 1;

        for (int i = 0; i < testCase; i++) {
            goal = Integer.parseInt(br.readLine());

            if (goal == 0 || goal == 1) {
                System.out.println(cnt[goal][0] + " " + cnt[goal][1]);
            } else {
                dp(0);

                System.out.println(cnt[goal][0] + " " + cnt[goal][1]);
            }
        }
    }

    public static void dp(int n) {

        if (n == 0 || n == 1) {
            dp(n + 1);
            return;
        }

        if (n == goal + 1)
            return;

        cnt[n][0] = cnt[n - 1][0] + cnt[n - 2][0];
        cnt[n][1] = cnt[n - 1][1] + cnt[n - 2][1];
        dp(n + 1);


    }
}