package boj;

/*
* 백준 : 테트로미노
* 풀이 : 기존 dfs 방식과 ㅗ방식을 따로 구별해서 풀이하였음.
* 메모리 35488kb , 시간 644ms
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14500 {

    public static int[][] grid;
    public static int row, col, ans;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        row = Integer.parseInt(input1[0]);
        col = Integer.parseInt(input1[1]);

        grid = new int[row][col];

        // input nums
        for (int i = 0; i < row; i++) {
            String[] isInputNums = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(isInputNums[j]);
            }
        }

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j], visited);
                visited[i][j] = false;
                check(i,j);
            }
        }

        System.out.println(ans);

    }

    public static void dfs(int r, int c, int cnt, int sum, boolean[][] visited) {

        if (cnt >= 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nc < 0 || nr >= row || nc >= col || visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + grid[nr][nc], visited);
            visited[nr][nc] = false;
        }

    }

    public static void check(int x, int y) {
        if (x < row - 2 && y < col - 1)
            ans = Math.max(ans, grid[x][y] + grid[x + 1][y] + grid[x + 2][y] + grid[x + 1][y + 1]);

        if (x < row - 2 && y > 0)
            ans = Math.max(ans, grid[x][y] + grid[x + 1][y] + grid[x + 2][y] + grid[x + 1][y - 1]);

        if (x < row - 1 && y < col - 2)
            ans = Math.max(ans, grid[x][y] + grid[x][y + 1] + grid[x][y + 2] + grid[x + 1][y + 1]);

        if (x > 0 && y < col - 2)
            ans = Math.max(ans, grid[x][y] + grid[x][y + 1] + grid[x][y + 2] + grid[x - 1][y + 1]);
    }

}



