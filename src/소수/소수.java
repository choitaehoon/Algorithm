package 소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 소수 {

    static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(buffer.readLine());
        int n = Integer.parseInt(buffer.readLine());

        mapDecimalNumber();

        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int i=m; i<=n; ++i)
            if (i >= 2 &&map.get(i) == null) {
                result += i;
                min = Math.min(min, i);
            }

        if (result != 0) {
            System.out.println(result);
            System.out.println(min);
        }
        else
            System.out.println(-1);


    }

    public static void mapDecimalNumber() {

        for (int i=2; i<=10000; ++i)
            for (int j=i*2; j<=10000; j= j+i)
                if (map.get(j) == null)
                    map.put(j, 1);
    }

}
