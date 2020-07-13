package 정렬;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Map<Integer, Integer> storeA = new HashMap<>();

        for (int value : A) {
            storeA.put(value, storeA.get(value) == null ? 1 : storeA.get(value) + 1);
        }

        for (Map.Entry<Integer, Integer> result : storeA.entrySet()) {
            if (result.getValue() % 2 != 0) {
                return result.getKey();
            }
        }

        return 0;
    }

}
