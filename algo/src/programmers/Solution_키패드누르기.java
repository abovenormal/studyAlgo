package programmers;

import java.util.*;

public class Solution_키패드누르기 {

    static class Keypad {
        int x;
        int y;

        Keypad(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<Integer, Keypad> numberMap = new HashMap<>();

        Keypad leftH = new Keypad(3, 0);
        Keypad rightH = new Keypad(3, 2);

        numberMap.put(1, new Keypad(0, 0));
        numberMap.put(2, new Keypad(0, 1));
        numberMap.put(3, new Keypad(0, 2));

        numberMap.put(4, new Keypad(1, 0));
        numberMap.put(5, new Keypad(1, 1));
        numberMap.put(6, new Keypad(1, 2));

        numberMap.put(7, new Keypad(2, 0));
        numberMap.put(8, new Keypad(2, 1));
        numberMap.put(9, new Keypad(2, 2));

        numberMap.put(0, new Keypad(3, 1));

        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        leftSet.add(1);
        leftSet.add(4);
        leftSet.add(7);

        rightSet.add(3);
        rightSet.add(6);
        rightSet.add(9);

        for (int i : numbers) {

            Keypad curLocate = numberMap.get(i);

            if (leftSet.contains(i)) {
                sb.append("L");
                leftH = curLocate;
            } else if (rightSet.contains(i)) {
                sb.append("R");
                rightH = curLocate;
            } else {

                int check = calLocate(leftH, rightH, curLocate);

                if (check == -1) {
                    sb.append("R");
                    rightH = curLocate;
                } else if (check == 1) {
                    sb.append("L");
                    leftH = curLocate;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftH = curLocate;
                    } else {
                        sb.append("R");
                        rightH = curLocate;
                    }
                }
            }


        }

        answer = sb.toString();

        System.out.println(answer);

        return sb.toString();
    }

    public static int calLocate(Keypad L, Keypad R, Keypad cur) {

        int lx = L.x;
        int ly = L.y;
        int rx = R.x;
        int ry = R.y;
        int curx = cur.x;
        int cury = cur.y;

        int leftDist = Math.abs(lx - curx) + Math.abs(ly - cury);
        int rightDist = Math.abs(rx - curx) + Math.abs(ry - cury);

        if (leftDist < rightDist) {
            return 1;
        } else if (rightDist < leftDist) {
            return -1;
        } else {
            return 0;
        }


    }

    public static void main(String[] args) {

        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
    }
}
