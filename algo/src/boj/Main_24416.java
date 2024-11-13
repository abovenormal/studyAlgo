import java.util.*;

public class Main {

    static int buttom_cnt = 0;
    static int top_cnt = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        map.put(1,1);
        map.put(2,1);

        btp(n);
        tpn(n);
        System.out.println(buttom_cnt + " " + top_cnt);

    }

    public static int btp(int n) {

        if (n == 1 || n == 2) {
            buttom_cnt++;
            return 1;
        } else {
            return (btp(n - 1) + btp(n - 2));
        }

    }

    public static int tpn(int n) {

        if(map.containsKey(n))
            return map.get(n);

        if (n == 1 || n == 2)
            return map.get(n);

        top_cnt++;
        map.put(n, tpn(n - 1) + tpn(n - 2));
        return map.get(n);
    }
}