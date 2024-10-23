import java.io.*;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.*;

/*
* 초기 : 4
* 1번 : 9 = 4 + 4 +1 = 3^2
* 2번 : 25 = 9 + (4*4 -4 +1 *4) = 5^2
* 3번 : 9^2
* */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(Math.pow(2,n)+1,2));

    }
}