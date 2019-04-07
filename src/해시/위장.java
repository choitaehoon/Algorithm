package 해시;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String,Integer> maps = new HashMap<>();

        for (int i=0; i<clothes.length; ++i)
            maps.put(clothes[i][1], maps.get(clothes[i][1]) == null ? 2 : maps.get(clothes[i][1])+1 );

        int result = 1;
        for (Map.Entry<String, Integer> map : maps.entrySet())
            result *= map.getValue();

        return result-1;
    }
}

