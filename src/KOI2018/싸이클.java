package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 싸이클 {

    public static int n;
    public static int cycleN;
    public static int p;
    public static Map<Integer,Integer> maps = new HashMap<>();

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        n = Integer.parseInt(token.nextToken());
        cycleN = n;
        p = Integer.parseInt(token.nextToken());
        int sum = 0;

        while (true)
            if (calculateCycle())
                break;

        for (Map.Entry<Integer,Integer> map : maps.entrySet())
            if (map.getValue() == 2)
                ++sum;

        System.out.println(sum);

    }

    public static boolean calculateCycle() {
        int key = (n*cycleN)%p;
        cycleN = key;
        if (maps.get(key) != null && maps.get(key) == 2)
            return true;

        maps.put(key, maps.get(key) == null ? 1 : maps.get(key)+1);
        return false;
    }

}
