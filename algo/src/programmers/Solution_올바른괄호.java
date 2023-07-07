package programmers;

import java.util.*;

public class Solution_올바른괄호 {

    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(char t : s.toCharArray()){
            if(!stack.isEmpty() && t==')'){
                stack.pop();
                continue;
            }
            stack.push(t);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        solution("(())(()");
    }
}
