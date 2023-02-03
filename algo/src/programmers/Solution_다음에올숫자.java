package programmers;

/*
* 프로그래머스 : 다음에 올 숫자
* 풀이 : a1,2,3을 비교하여 공차와 공비를 확인해서 수열을 판단하기.
 테스트 1 〉	통과 (0.02ms, 73.6MB)
테스트 2 〉	통과 (0.01ms, 81.5MB)
테스트 3 〉	통과 (0.02ms, 71.6MB)
테스트 4 〉	통과 (0.02ms, 74MB)
테스트 5 〉	통과 (0.03ms, 72.5MB)
테스트 6 〉	통과 (0.01ms, 64.7MB)
테스트 7 〉	통과 (0.01ms, 74.8MB)
테스트 8 〉	통과 (0.02ms, 75.8MB)
테스트 9 〉	통과 (0.01ms, 74.6MB)
* */

public class Solution_NextArrayNum {

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{0,0,0}));
        System.out.println(solution(new int[]{2, 4, 8}));
    }

    public static int solution(int[] common) {
        int answer = 0;
        int len = common.length;

        if(check(common)){
            answer = common[len-1] + d1(common);
        }else{
            answer = common[len-1] * r1(common);
        }

        return answer;
    }

    public static boolean check(int[] arr){
        if(arr[2]-arr[1] == arr[1]-arr[0])
            return true;
        else
            return false;
    }

    public static int d1(int[] arr){
        return arr[1]-arr[0];
    }

    public static int r1(int[] arr){
        return arr[1]/arr[0];
    }

}
