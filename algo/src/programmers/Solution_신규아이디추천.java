package programmers;

public class Solution_신규아이디추천 {

    public static String solution(String new_id) {
        String answer = "";

        // step1
        String step1 = new_id.toLowerCase();

        // step2
        char[] step1Arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();

        for(char c : step1Arr){
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
                    || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }

        // step3
        String step3 = step2.toString().replace("..",".");
        while(step3.contains("..")){
            step3 = step3.replace("..",".");
        }

        // step4
        String step4 = step3;
        if (step4.length() > 0) {
            if (step4.charAt(0) == '.') {
                step4 = step4.substring(1, step4.length());
            }
        }
        if (step4.length() > 0) {
            if (step4.charAt(step4.length() - 1) == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }

        // step5
        String step5 = step4;
        if (step5.equals("")) {
            step5 = "a";
        }

        // step6
        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);

            if (step6.charAt(step6.length() - 1) == '.') {
                step6 = step6.substring(0, step6.length() - 1);
            }
        }

        // step7
        StringBuilder step7 = new StringBuilder(step6);
        if (step7.length() <= 2) {
            char last = step7.charAt(step7.length() - 1);

            while (step7.length() < 3) {
                step7.append(last);
            }
        }

        answer = String.valueOf(step7);
        return answer;
    }

    public static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghijklm");

    }
}
