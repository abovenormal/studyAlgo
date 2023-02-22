package programmers;

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
