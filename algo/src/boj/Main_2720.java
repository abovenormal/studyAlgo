import java.io.*;
import java.util.*;

/*
 * 잔돈 남겨주기 -> 그리드로 추정
 * 쿼터(25) 다임(10) 니켈(5) 페니(1)
 * */

class Change {
    int qtr, dime, nikel, penny;

    Change() {
        this.qtr = 25;
        this.dime = 10;
        this.nikel = 5;
        this.penny = 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int curChange = Integer.parseInt(br.readLine());
            chageCoin(curChange);
            System.out.println();
        }

    }

    public static void chageCoin(int money) {
        Change c = new Change();

        System.out.print(money / c.qtr + " ");
        money %= c.qtr;
        System.out.print(money / c.dime + " ");
        money %= c.dime;
        System.out.print(money / c.nikel + " ");
        money %= c.nikel;
        System.out.print(money / c.penny + " ");
    }
}