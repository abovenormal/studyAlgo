package programmers;

import java.util.*;

public class Solution_카드뭉치 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        boolean check = true;
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        for (String s : cards1) {
            q1.add(s);
        }
        for (String s : cards2) {
            q2.add(s);
        }

        for (String s : goal) {
            if (Objects.equals(q1.peek(),s) && !q1.isEmpty()) {
                q1.remove();
            } else if (Objects.equals(q2.peek(), s) && !q2.isEmpty()) {
                q2.remove();
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            answer = "Yes";
        } else {
            answer = "No";
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }
}
