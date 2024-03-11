//package boj;
//
//import javax.xml.ws.BindingType;
//import java.io.*;
//import java.util.*;
//
//class Node7576 {
//    int x, y;
//
//    Node7576(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Main_7576 {
//
//    public static int n, m;
//    public static int[][] tomato;
//    public static int[][] cntDays;
//    public static int[] dx = {-1, 1, 0, 0};
//    public static int[] dy = {0, 0, -1, 1};
//
//    public static Queue<Node7576> queue = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        tomato = new int[m][n];
//        cntDays = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            for (int j = 0; j < n; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//                tomato[i][j] = temp;
//                cntDays[i][j] = -1;
//
//                if(temp==-1){
//                    cntDays[i][j] = 0;
//                }
//                if (temp == 1) {
//                    queue.add(new Node7576(i, j));
//                    cntDays[i][j] = 0;
//                }
//            }
//        }
//
//        int ans = bfs();
//
//        System.out.println(ans);
//
//    }
//
//    private static int bfs() {
//
//        while (!queue.isEmpty()) {
//
//            Node7576 node = queue.remove();
//
//            int curX = node.x;
//            int curY = node.y;
//
//            for (int i = 0; i < 4; i++) {
//                int nextX = curX + dx[i];
//                int nextY = curY + dy[i];
//
//                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
//                    if(tomato[nextX][nextY]==0 && cntDays[nextX][nextY]==-1){
//                        queue.add(new Node7576(nextX,nextY));
//                        cntDays[nextX][nextY] = cntDays[curX][curY]+1 ;
//                    }
//                }
//
//            }
//        }
//
//        int days = Integer.MIN_VALUE;
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(cntDays[i][j]==-1)
//                    return -1;
//                days = Math.max(days,cntDays[i][j]);
//            }
//        }
//
//        return days;
//
//    }
//
//}
