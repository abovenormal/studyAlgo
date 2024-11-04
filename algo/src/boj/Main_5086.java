import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0) return;

            if(n>m){
                if(n%m==0) System.out.println("multiple");else System.out.println("neither");
            }else{
                if(m%n==0) System.out.println("factor");else System.out.println("neither");
            }
        }
    }
}