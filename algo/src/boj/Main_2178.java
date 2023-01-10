package boj;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Node1 {
    int x, y;

    Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2178 {

    public static int n, m;
    public static int[][] map;
    public static int[][] dist;
    public static Queue<Node1> queue;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        queue = new LinkedList<Node1>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = m - 1; j >= 0; j--) {
                map[i][j] = line.charAt(j)-'0';
                dist[i][j] = -1;
            }
        }

        dist[0][0]=0;
        queue.add(new Node1(0, 0));

        bfs();

        System.out.println(dist[n-1][m-1]+1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node1 curNode = queue.poll();

            int x = curNode.x;
            int y = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && dist[nx][ny]==-1) {
                        dist[nx][ny] = dist[x][y]+1;
                        queue.add(new Node1(nx, ny));
                    }
                }
            }

        }
    }
}
