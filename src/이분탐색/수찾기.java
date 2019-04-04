package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수찾기 {

    static Map<Integer,Integer> maps = new HashMap<>();

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer nToken = new StringTokenizer(buffer.readLine());

        int m = Integer.parseInt(buffer.readLine());
        StringTokenizer mToken = new StringTokenizer(buffer.readLine());

        for (int i=0; i<n; ++i) {
            int number = Integer.parseInt(nToken.nextToken());
            maps.put(number, maps.get(number) == null ? 1 : maps.get(number)+1);
        }

        for (int i=0; i<m; ++i) {
            int number = Integer.parseInt(mToken.nextToken());
            System.out.println(maps.get(number) == null ? 0 : 1);
        }

    }
}
