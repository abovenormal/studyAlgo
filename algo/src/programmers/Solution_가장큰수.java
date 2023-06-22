package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_가장큰수 {
    public static String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
                .mapToObj(n->String.valueOf(n))     // mapToObj(String::valueof)
                .sorted((s1,s2)->(s2+s1).compareTo(s1+s2))
                .collect(Collectors.joining());

        if(answer.startsWith("0"))
            return "0";

        return answer;

    }

    public static void main(String[] args) {

        solution(new int[]{3, 30, 34, 5, 9});

    }
}
