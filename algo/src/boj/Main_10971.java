//import java.io.*;
//
//public class Boj_10971 {
//    public static int N;
//    public static int minVal = Integer.MAX_VALUE;
//    public static int[][] arr;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        N = Integer.parseInt(br.readLine());
//
//        arr = new int[N + 1][N + 1];
//        boolean[] visited = new boolean[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            String[] sarr = br.readLine().split(" ");
//            for (int j = 1; j <= N; j++) {
//                arr[i][j] = Integer.parseInt(sarr[j - 1]);
//            }
//        }
//
//        visited[1] = true;
//        dfs(1,1,1,0,visited);
//
//        bw.write(minVal+"\n");
//        bw.flush();
//    }
//
//    public static void dfs(int start, int cur, int cnt, int cost, boolean[] visited) {
//
//        if (cur == start && cost > 0) {
//            minVal = Math.min(minVal, cost);
//            return;
//        }
//
//        for (int n = 1; n <= N; n++) {
//
//            if (arr[cur][n] > 0) {
//                if (n == start && cnt == N) {
//                    cost += arr[cur][n];
//                    dfs(start, n, cnt + 1, cost, visited);
//                } else if (!visited[n]) {
//                    visited[n] = true;
//                    cost += arr[cur][n];
//
//                    dfs(start, n, cnt + 1, cost, visited);
//
//                    cost -= arr[cur][n];
//                    visited[n] = false;
//                }
//            }
//
//        }
//
//    }
//}
