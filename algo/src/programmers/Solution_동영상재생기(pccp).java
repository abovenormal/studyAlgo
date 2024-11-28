/*
* 프로그래머스 동영상 재생기
* lv 1
* 구현, 분을 초로 환산하여 계산함
* */


import java.util.*;

public class Solution {

    static int videoL;
    static int curPos;
    static int oStart;
    static int oEnd;

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        videoL = timeCal(video_len);
        curPos = timeCal(pos);
        oStart = timeCal(op_start);
        oEnd = timeCal(op_end);

        for (String s : commands) {
            checkOpPeriod();
            if (s.equals("prev")) {
                curPos -= 10;
            } else if (s.equals("next")) {
                curPos += 10;
            }
        }
       checkOpPeriod();
        int ansM = curPos / 60;
        curPos %= 60;

        if (ansM < 10) {
            sb.append("0");
            sb.append(ansM);
        } else {
            sb.append(ansM);
        }
        sb.append(":");
        if (curPos < 10) {
            sb.append("0");
            sb.append(curPos);
        } else {
            sb.append(curPos);
        }

        answer = sb.toString();

        return answer;
    }

    public static int timeCal(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        return min * 60 + sec;
    }

    public static void checkOpPeriod() {
        if (curPos < 0)
            curPos =0;
        else if (curPos >= videoL) {
            curPos = videoL;
        }
        if (curPos >= oStart && curPos <= oEnd) {
            curPos = oEnd;
        }
    }

    public static void main(String[] args) {
        //String tc1 = solution("34:33", "13:00", "00:44", "02:55", new String[]{"next", "prev"});    // 13:00
        String tc2 = solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"});     // 06:55
        //String tc3 = solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"});    // 04:17
        //String tc4 = solution("10:00", "00:03", "00:00", "00:05", new String[]{"prev", "next"});

        //System.out.println(tc1 + " , " + tc2 + " , " + tc3);
        System.out.println(tc2);
    }
}