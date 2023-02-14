package programmers;

/*
프로그래머스 : 무인도 여행
풀이 : dfs로 근접 섬을 탐색하여 리스트에 넣고 소팅한 후 배열에 넣어준다
실행결과 :
테스트 1 〉	통과 (0.10ms, 75.6MB)
테스트 2 〉	통과 (0.49ms, 75.6MB)
테스트 3 〉	통과 (0.39ms, 78.8MB)
테스트 4 〉	통과 (0.55ms, 77.1MB)
테스트 5 〉	통과 (0.86ms, 83.6MB)
테스트 6 〉	통과 (1.00ms, 77.6MB)
테스트 7 〉	통과 (0.73ms, 68.9MB)
테스트 8 〉	통과 (1.62ms, 74.9MB)
테스트 9 〉	통과 (1.20ms, 73MB)
테스트 10 〉	통과 (1.57ms, 76.1MB)
테스트 11 〉	통과 (1.17ms, 73.6MB)
테스트 12 〉	통과 (1.53ms, 78.5MB)
테스트 13 〉	통과 (2.19ms, 79.7MB)
테스트 14 〉	통과 (1.71ms, 75.8MB)
테스트 15 〉	통과 (2.22ms, 76.1MB)
테스트 16 〉	통과 (2.41ms, 78MB)
테스트 17 〉	통과 (0.51ms, 76.5MB)
테스트 18 〉	통과 (2.21ms, 80MB)
테스트 19 〉	통과 (2.22ms, 73.8MB)
테스트 20 〉	통과 (1.13ms, 74.9MB)
테스트 21 〉	통과 (2.09ms, 78MB)
테스트 22 〉	통과 (0.37ms, 78.2MB)
테스트 23 〉	통과 (19.20ms, 93.3MB)
테스트 24 〉	통과 (5.02ms, 70.7MB)
테스트 25 〉	통과 (0.45ms, 71.8MB)
* */


import java.util.*;

public class Solution_무인도여행 {

    public static int row, col;

    public static int[][] grid;

    public static int[] solution(String[] maps) {
        List<Integer> answer = new LinkedList<>();

        String temp = maps[0];
        row = temp.length();
        col = maps.length;

        grid = new int[col][row];

        for (int i = 0; i < col; i++) {

            char[] c = maps[i].toCharArray();

            for (int j = 0; j < row; j++) {
                char t = c[j];
                if (t == 'X') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = t - '0';           // char 형태의 값을 int로 변형하기!
                }
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int isLandSum = dfs(i, j);
                if (isLandSum > 0) {
                    answer.add(isLandSum);
                }
            }
        }

        if (answer.size() == 0) {
            return new int[]{-1};
        }

        Collections.sort(answer);       // 오름차순으로 바꾼 다음

        int[] answerArray = new int[answer.size()];         // 배열에 넣어주기

        for (int i = 0; i < answerArray.length; i += 1) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

    public static int dfs(int i, int j) {

        if (i < 0 || j < 0 || i >= col || j >= row) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;

        return temp + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}));
    }
}
