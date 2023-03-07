package boj;

import java.io.*;

public class Main_1463 {

    public static int[] td;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        td = new int[n + 1];

        topDown(n);
        System.out.println(td[n]);
    }

    public static int topDown(int curN) {
        if (curN == 1)
            return 0;
        if (td[curN] != 0)
            return td[curN];

        int result = topDown(curN - 1) + 1;
        if (curN % 3 == 0) {
            result = Math.min(result, topDown(curN / 3) + 1);
        }
        if (curN % 2 == 0) {
            result = Math.min(result, topDown(curN / 2) + 1);
        }

        td[curN] = result;
        return result;
    }

}
