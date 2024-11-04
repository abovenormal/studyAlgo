import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        // input
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        // logic

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(i, j);
            }
        }
        System.out.println(ans);

    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        boolean check = map[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (map[i][j] != check) cnt++;

                check = !check;
            }
            check = !check;
        }


        cnt = Math.min(cnt, 64 - cnt);

        ans = Math.min(ans, cnt);

    }
}
