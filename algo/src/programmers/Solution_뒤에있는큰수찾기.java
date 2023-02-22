package programmers;

/*
* 프로그래머스 : 뒤에 있는 큰 수 찾기.
* 풀이 : 스택을 활용하여 앞에서부터 순회하였다. 그렇게 되다보니 스택에 남겨져있는 데이터 때문에 테스트 8~23에선 앞선 테스트와 다르게
*       시간이 더 길게 나왔다. 기울기 문제와 비슷하다고 하니 다른 방식으로 수정해서 해보아야겠다.
* 실행결과 :
* 테스트 1 〉	통과 (0.29ms, 70.6MB)
테스트 2 〉	통과 (0.44ms, 84.4MB)
테스트 3 〉	통과 (0.38ms, 71MB)
테스트 4 〉	통과 (0.65ms, 83.5MB)
테스트 5 〉	통과 (1.45ms, 71.5MB)
테스트 6 〉	통과 (7.57ms, 85.7MB)
테스트 7 〉	통과 (4.06ms, 85.7MB)
테스트 8 〉	통과 (18.14ms, 91.4MB)
테스트 9 〉	통과 (15.98ms, 102MB)
테스트 10 〉	통과 (29.94ms, 106MB)
테스트 11 〉	통과 (30.04ms, 122MB)
테스트 12 〉	통과 (36.12ms, 117MB)
테스트 13 〉	통과 (40.11ms, 133MB)
테스트 14 〉	통과 (54.85ms, 143MB)
테스트 15 〉	통과 (69.85ms, 198MB)
테스트 16 〉	통과 (61.07ms, 205MB)
테스트 17 〉	통과 (71.05ms, 221MB)
테스트 18 〉	통과 (70.36ms, 205MB)
테스트 19 〉	통과 (70.59ms, 187MB)
테스트 20 〉	통과 (80.05ms, 209MB)
테스트 21 〉	통과 (77.06ms, 198MB)
테스트 22 〉	통과 (54.41ms, 170MB)
테스트 23 〉	통과 (67.62ms, 186MB)
* */

import java.io.*;
import java.util.*;

class Pointer{
    int idx, num;

    Pointer(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
}
public class Solution_뒤에있는큰수찾기 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Pointer> stack = new Stack<>();

        for(int i=0; i<numbers.length ;i++){
            while(!stack.isEmpty() && numbers[i] > stack.peek().num){
                Pointer curP = stack.pop();
                answer[curP.idx] = numbers[i];
            }
            stack.add(new Pointer(i,numbers[i]));
        }

        while(!stack.isEmpty()){
            Pointer curP = stack.pop();
            answer[curP.idx] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] ans1 = solution(new int[] {2, 3, 3, 5});
        int[] ans2 = solution(new int[] {9, 1, 5, 3, 6, 2});

        for(int i : ans1) System.out.print(i+" ");
        System.out.println();
        for(int i : ans2) System.out.print(i+" ");

    }
}
