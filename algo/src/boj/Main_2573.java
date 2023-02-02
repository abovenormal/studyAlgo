package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 백준 2573 빙산
 * 132196kb / 520ms
 * bfs와 dfs를 모두 사용해야함
 * 빙산이 갈라지는데까지 걸리는 시간을 구하는 문제
 * 빙산이 녹을 때 주위에 바다와 접촉한 면 만큼 차감되나, 감소된 빙산이 그 다음 결과에 영향을 주어 필요 이상으로 많이 녹이므로 고려해야함.
 * 빙산이 붙어있는지를 확인하기 위해 dfs로 확인하였음
 *
 * */

class Ice {
    int x, y;

    Ice(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2573 {

    public static int n, m;
    public static int[][] map;
    public static int[][] nextMap;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = parsingInt(input[0]);
        m = parsingInt(input[1]);

        map = new int[n][m];
        nextMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = parsingInt(temp[j]);
            }
        }

        int ans =0;
        int cnt =0;

        while((cnt=DividedBerg())<2){
            if(cnt==0){
                ans = 0;
                break;
            }
            bfs();
            ans++;
        }

        System.out.println(ans);

    }

    public static int DividedBerg() {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited) {

        visited[x][y] = true;

        int nextX, nextY;

        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if (nextX >= 0 || nextY >= 0 || nextX < n || nextY < m) {
                if (map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY, visited);
                }
            }
        }
    }

    public static void bfs() {

        Queue<Ice> queue = new LinkedList<>();

        boolean[][] check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] !=0){
                    queue.add(new Ice(i,j));
                    check[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()){

            Ice curIce = queue.remove();
            int nearOcean = 0;

            for(int i=0;i<4;i++){
                int nextX = curIce.x + dx[i];
                int nextY = curIce.y + dy[i];

                if(nextX>=0&&nextY>=0&&nextX<n||nextY<m){
                    if(!check[nextX][nextY] && map[nextX][nextY]==0){
                        nearOcean++;
                    }
                }
            }

            if(map[curIce.x][curIce.y]-nearOcean<0){
                map[curIce.x][curIce.y] =0;
            }
            else
                map[curIce.x][curIce.y] -= nearOcean;
        }

    }

    public static int parsingInt(String input) {
        return Integer.parseInt(input);
    }
}