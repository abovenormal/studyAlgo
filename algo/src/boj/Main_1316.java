import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String temp = sc.next();
            Boolean check = true;
            String[] arr = temp.split("");

            for (int j = 0; j < arr.length; j++) {

                if (map.containsKey(arr[j])) {
                    if (map.get(arr[j]) != (j - 1)) {
                        check = false;
                        break;
                    } else {
                        map.put(arr[j], j);
                    }
                } else {
                    map.put(arr[j], j);
                }
            }

            if (check) ans++;
        }

        System.out.println(ans);
    }
}