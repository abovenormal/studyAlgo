package programmers;

/*
프로그래머스 : 최소직사각형
풀이 : 복잡하게 생각하는 것 보다 간단하게 수학 푸는 것처럼 풀 때가 도움이 되는 경우이었다.

실행결과 :
테스트 1 〉	통과 (0.02ms, 72.5MB)
테스트 2 〉	통과 (0.04ms, 69.9MB)
테스트 3 〉	통과 (0.04ms, 71.3MB)
테스트 4 〉	통과 (0.03ms, 73.9MB)
테스트 5 〉	통과 (0.03ms, 74.2MB)
테스트 6 〉	통과 (0.05ms, 80.5MB)
테스트 7 〉	통과 (0.02ms, 76.6MB)
테스트 8 〉	통과 (0.03ms, 77.2MB)
테스트 9 〉	통과 (0.07ms, 67.6MB)
테스트 10 〉	통과 (0.09ms, 82.3MB)
테스트 11 〉	통과 (0.06ms, 75.1MB)
테스트 12 〉	통과 (0.05ms, 74MB)
테스트 13 〉	통과 (0.21ms, 74.9MB)
테스트 14 〉	통과 (0.30ms, 74.3MB)
테스트 15 〉	통과 (0.39ms, 72.4MB)
테스트 16 〉	통과 (0.69ms, 75.9MB)
테스트 17 〉	통과 (1.31ms, 80.4MB)
테스트 18 〉	통과 (1.27ms, 91.6MB)
테스트 19 〉	통과 (1.72ms, 85.9MB)
테스트 20 〉	통과 (2.17ms, 83.3MB)

* */
public class Solution_최소직사각형 {

    public static int solution(int[][] sizes) {

        int longP = 0;
        int shortP = 0;

        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            int lp = Math.max(size[0], size[1]);
            int sp = Math.min(size[0], size[1]);

            longP = Math.max(longP, lp);
            shortP = Math.max(shortP, sp);
        }

        return longP * shortP;

    }

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));

    }
}
