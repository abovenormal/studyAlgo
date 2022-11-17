package programmers;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_k진수에서_소수_개수_구하기 {
    public static int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> numbers = new LinkedList<>();

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        sb = sb.reverse();
        String changedNumber = sb.toString();

        for (int i = 0; i < changedNumber.length(); i++) {
            for (int j = 0; j < changedNumber.length();j++) {
            }
        }


        for (int i = 0; i < numbers.size(); i++) {

            int isPrime = numbers.get(i);
            if (isPrime == 1)
                continue;

            boolean checkValue = true;

            double y = Math.sqrt(isPrime);

            for (int j = 2; j <= y; j++) {
                if (isPrime % j == 0) {
                    checkValue = false;
                    break;
                }
            }

            if (checkValue == true) {
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {

        int n = 437674;
        int k = 3;

        solution(n, k);
    }
}
