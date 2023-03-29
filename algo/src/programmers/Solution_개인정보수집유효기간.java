package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/*
* 프로그래머스 개인정보수집유효기간
* 풀이 : 달력을 글자 그대로 형식을 유지해가며 문제를 풀이하였으나 찾아보니
*       굳이 형식을 유지하는 것 보단 1년 = 1달 * 12 = 1일 * 12 * 28 이러한 형식으로
*       값을 변환하여 더 빠르게 해결 할 수 있는 문제였다.
*
* */

public class Solution_개인정보수집유효기간 {

    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termList = new HashMap<>();

        // 유효기간 정리하기.
        for (String s : terms) {
            st = new StringTokenizer(s);
            String key = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            termList.put(key, val);
        }

        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String curDate = st.nextToken();
            String curTerm = st.nextToken();

            boolean check = dateCal(today, curDate, curTerm, termList);

            if (!check) answer.add(i + 1);
        }


        return answer;
    }

    public static boolean dateCal(String today, String curDate, String curTerm, HashMap<String, Integer> termList) {
        String[] todayList = today.split("[.]");
        String[] curdateList = curDate.split("[.]");

        int year = Integer.parseInt(curdateList[0]);
        int month = Integer.parseInt(curdateList[1]) + termList.get(curTerm);
        int date = Integer.parseInt(curdateList[2]) - 1;

        if (date == 0) {
            month -= 1;
            date = 28;
            if(month==0)
                month=12;
        }

        if (month > 12) {
            int temp = month/12;
            month %=12;
            if(month==0)
            {
                year += (temp-1);
                month=12;
            }
            year+=temp;
        }


        if (year < Integer.parseInt(todayList[0])) {
            return false;
        } else if (year == Integer.parseInt(todayList[0])) {
            if (month < Integer.parseInt(todayList[1]))
                return false;
            else if (month == Integer.parseInt(todayList[1])) {
                if (date < Integer.parseInt(todayList[2]))
                    return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
         List<Integer> a = solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

        //List<Integer> a = solution("2021.12.08", new String[]{"A 18"}, new String[]{"2020.06.08 A"});
        for (int i : a) {
            System.out.println(i);
        }
    }
}