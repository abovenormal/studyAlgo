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

        for (int i = 0; i < cities.length; i++) {
            if (lru.size() < cacheSize) {
                lru.add(cities[i].toLowerCase());
                answer += 5;
            } else {
                if (lru.contains(cities[i].toLowerCase())) {
                    lru.remove(cities[i].toLowerCase());
                    lru.add(cities[i].toLowerCase());
                    answer += 1;
                } else {
                    lru.removeFirst();
                    lru.add(cities[i].toLowerCase());
                    answer += 5;
                }
            }

            System.out.println(lru);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        System.out.println(solution(3, cities));
    }
}
