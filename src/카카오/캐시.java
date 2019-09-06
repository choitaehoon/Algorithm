package 카카오;

import java.util.LinkedHashMap;
import java.util.Map;

public class 캐시 {
    public static void main(String[] args) {
//        System.out.println(solution());
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;

        int time = 0;

        Map<String, Integer> map = new LinkedHashMap<String, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize;
            }
        };

        for (String key : cities) {
            if (map.containsKey(key.toUpperCase()))
                time += 1;

            else {
                time += 5;
                map.put(key.toUpperCase(),null);
            }

        }

        return time;
    }
}
