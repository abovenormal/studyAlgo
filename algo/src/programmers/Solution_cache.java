package programmers;

import java.util.*;

public class Solution_cache {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> lru = new LinkedList<>();

        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        for(int i=0;i< cities.length;i++){
            String s = cities[i].toLowerCase();

            if(lru.remove(s)){
                answer+=1;
                lru.add(s);
            }
            else{
                answer+=5;
                if(lru.size()>=cacheSize){
                    lru.remove(0);
                }
                lru.add(s);
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        System.out.println(solution(3, cities));
    }
}
