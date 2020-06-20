package 해시;

import java.util.HashMap;
import java.util.Map;

public class 위장1 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        Map<String, Integer> camouflage = new HashMap<>();

        int clothesLen = clothes.length;
        for (int i = 0; i < clothesLen; ++i) {
            camouflage.put(clothes[i][1], camouflage.getOrDefault(clothes[i][1], 0) + 1);
        }

        int result = 1;
        for (int value : camouflage.values())
            result *= (value + 1);

        return result - 1;
    }
}
