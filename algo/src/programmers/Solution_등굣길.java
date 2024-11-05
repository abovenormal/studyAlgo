import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map;
    static int mod = 1000000007;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = -1;
            }
        }

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -2;
        }

        answer = (find(n - 1, m - 1, n, m)) % mod;

        return answer;
    }

    public static int find(int x, int y, int n, int m) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (map[x][y] != -1) {
            return map[x][y];
        } else {
            map[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != -2) {
                    if (nx < x || ny < y)
                        map[x][y] += (find(nx, ny, n, m) % mod);
                }
            }
        }
        return map[x][y];
    }

    public static void main(String[] args) {
        //int ans = solution(4, 3, new int[][]{{2, 2}});
         int ans = solution(7, 4, new int[][] {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}});
        // int ans = solution(100, 100, new int[][]{});

        System.out.println(ans);
    }
}