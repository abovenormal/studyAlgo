import java.util.*;

public class Solution {

    public static String Solution(String s) {
        String[] arrStr = s.split(" ");
        int[] arrInt = new int[arrStr.length];
        int i=0;
        for(String part : arrStr){
            arrInt[i] = Integer.parseInt(part);
            i++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());

        return sb.toString();
    }

    // split과 stream 클래스를 활용한 문제 풀이
    public static String solution1(String s) {
        String[] arrStr = s.split(" ");
        int[] arrInt = new int[arrStr.length];
        int i=0;
        for(String part : arrStr){
            arrInt[i] = Integer.parseInt(part);
            i++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());

        return sb.toString();
    }

    public static void main(String[] args) {

        String s1 = Solution("1 2 3 4");
        System.out.println(s1);

        String s2 = Solution("-1 -2 -3 -4");
        System.out.println(s2);

        String s3 = Solution("-1 -1 ");
        System.out.println(s3);

    }
}