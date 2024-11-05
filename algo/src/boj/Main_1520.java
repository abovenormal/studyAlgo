/* 백준 1520 내리막길
 * dfs + dp
 * */

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(find(n - 1, m - 1));

    }

    public static int find(int x, int y) {
        if (x == 0 && y == 0)
            return 1;
        if (dp[x][y] != -1) {
            return dp[x][y];
        } else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >=0 && nx < n && ny < m) {
                    if (map[x][y] < map[nx][ny]) {
                        dp[x][y] += find(nx, ny);
                    }
                }
            }
        }
        return dp[x][y];
    }
}