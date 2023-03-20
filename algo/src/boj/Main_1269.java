package boj;

/*
* 문제 : 백준 대칭 차집합
* 풀이 : set의 treeset을 이용하여 시간 복잡도를 logN으로 하여 해결
* 실행결과 : 90376kb	824ms
* */
import java.io.*;
import java.util.*;

public class Main_1269 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int a,b;

        st = new StringTokenizer(br.readLine());

        a = parsingInt(st.nextToken());
        b = parsingInt(st.nextToken());

        Set<Integer> aList = new TreeSet<>();
        Set<Integer> bList = new TreeSet<>();

        StringTokenizer tempA = new StringTokenizer(br.readLine());
        StringTokenizer tempB = new StringTokenizer(br.readLine());

        while(a!=0){
            aList.add(parsingInt(tempA.nextToken()));
            a--;
        }

        while(b!=0){
            int curB = parsingInt(tempB.nextToken());

            if(!aList.remove(curB)){
                bList.add(curB);
            }
            b--;
        }

        System.out.println(aList.size()+bList.size());

    }

    public static int parsingInt(String s){

        return Integer.parseInt(s);
    }
}
