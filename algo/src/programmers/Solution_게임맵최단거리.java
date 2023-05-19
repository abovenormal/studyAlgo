package programmers;

/*
* 프로그래머스 : 게임 맵 최단거리
* 풀이 : bfs로 푸는 전형적인 문제
* 실행결과
* 정확성  테스트
테스트 1 〉	통과 (0.39ms, 77.7MB)
테스트 2 〉	통과 (0.35ms, 72.1MB)
테스트 3 〉	통과 (0.32ms, 75MB)
테스트 4 〉	통과 (0.43ms, 73.2MB)
테스트 5 〉	통과 (0.42ms, 73.7MB)
테스트 6 〉	통과 (0.50ms, 71.1MB)
테스트 7 〉	통과 (0.43ms, 74.3MB)
테스트 8 〉	통과 (0.49ms, 87.5MB)
테스트 9 〉	통과 (0.49ms, 73.6MB)
테스트 10 〉	통과 (0.34ms, 73.3MB)
테스트 11 〉	통과 (0.32ms, 72.9MB)
테스트 12 〉	통과 (0.50ms, 68.8MB)
테스트 13 〉	통과 (0.57ms, 71.9MB)
테스트 14 〉	통과 (0.36ms, 76.3MB)
테스트 15 〉	통과 (0.32ms, 72.2MB)
테스트 16 〉	통과 (0.32ms, 68.2MB)
테스트 17 〉	통과 (0.35ms, 74.2MB)
테스트 18 〉	통과 (0.42ms, 82.8MB)
테스트 19 〉	통과 (0.49ms, 77.4MB)
테스트 20 〉	통과 (0.40ms, 74.6MB)
테스트 21 〉	통과 (0.32ms, 73.9MB)
효율성  테스트
테스트 1 〉	통과 (7.01ms, 53.2MB)
테스트 2 〉	통과 (2.96ms, 52.9MB)
테스트 3 〉	통과 (14.22ms, 53.6MB)
테스트 4 〉	통과 (4.76ms, 71MB)
*
* */
import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int row,col;

    public static int solution(int[][] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length;

        visited = new boolean[row][col];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));

        visited[0][0] = true;

        answer = bfs(queue, maps);

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }

    public static int bfs(Queue<Node> queue, int[][] maps) {

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();

            int curX = curNode.x;
            int curY = curNode.y;
            int curCnt = curNode.cnt;

            if (curX == row - 1 && curY == col - 1) {
                min = Math.min(min, curCnt);
            }

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX >= 0 && nX < row && nY >= 0 && nY < col && !visited[nX][nY] && maps[nX][nY] == 1) {
                    queue.add(new Node(nX, nY, curCnt + 1));
                    visited[nX][nY] = true;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int a= solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 1, 1}
        });
        System.out.println(a);
    }
}
