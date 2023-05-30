package programmers;

/*
* 프로그래머스 : 신고 결과 받기 (https://school.programmers.co.kr/learn/courses/30/lessons/92334)
* 풀이 : Map과 Set을 활용해서 자료를 모아서 계산 하였음.
*       최근 map에 저장되어 있는 모든 값을 가져오는 문제가 있었기에 미리 풀고 가면 좋았을것 같은 문제.
*
*
* */
import java.util.*;

public class Solution_신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k)  {
        int[] answer = {};
        answer = new int[id_list.length];

        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportingId = new HashSet<>();
            map.put(id_list[i], reportingId);
            answerMap.put(id_list[i], 0);
        }

        for (String temp : report) {
            StringTokenizer st = new StringTokenizer(temp);
            String key = st.nextToken();
            String val = st.nextToken();
            map.get(val).add(key);
        }

//        System.out.println("[STEP 2] reportedMap 에 신고 기록 세팅 : " + map);

        for (String key : map.keySet()) {
            HashSet<String> reportedSet = map.get(key);
            if (reportedSet.size() >= k) {
                for (String id : reportedSet) {
                    answerMap.put(id, answerMap.get(id) + 1);
//                    System.out.println(id +" : "+answerMap.get(id));

                }
            }
        }

//        System.out.println("[STEP 3] answerMap 에 메일 수 세팅 : " + answerMap);

        for(int i=0;i<id_list.length;i++){
            answer[i] = answerMap.get(id_list[i]);
//            System.out.println("[STEP 4] answer : " + answer[i]);
        }


        return answer;

    }

    public static void main(String[] args)  {

         int [] i = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"} ,2);

        //int[] i = solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
    }
}
