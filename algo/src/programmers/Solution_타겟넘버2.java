package programmers;

/*
프로그래머스 : 타겟 넘버
풀이 : 앞선 방법과 다르게 dfs로 풀이 하였습니다.
      이전 방법보다 실행 속도가 훨씬 감소된 것을 확인 할 수 있었습니다.

실행 결과 :
테스트 1 〉	통과 (4.44ms, 77.2MB)
테스트 2 〉	통과 (4.70ms, 73.1MB)
테스트 3 〉	통과 (0.19ms, 74.9MB)
테스트 4 〉	통과 (0.44ms, 77.1MB)
테스트 5 〉	통과 (0.67ms, 74MB)
테스트 6 〉	통과 (0.33ms, 78.3MB)
테스트 7 〉	통과 (0.20ms, 67.2MB)
테스트 8 〉	통과 (0.34ms, 73.8MB)

* */
public class Solution_타겟넘버2 {
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers,target,0,0);

        return answer;
    }

    public static int dfs(int[]numbers,int target, int i, int sum){

        if(i == numbers.length) {
            if(sum==target){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, target,i + 1, sum + numbers[i]) + dfs(numbers,target, i + 1, sum - numbers[i]);

    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1,1,1}, 3));
        System.out.println(solution(new int[] {4,1,2,1}, 4));
    }
}
