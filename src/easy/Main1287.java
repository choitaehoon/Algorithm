package easy;

import java.util.HashMap;
import java.util.Map;

public class Main1287 {

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(
                new int[]{1,2,2,6,6,6,6,7,10}
        ));
    }

    public static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> countArr = new HashMap<>();

        for (int arrValue : arr) {
            countArr.put(arrValue, countArr.getOrDefault(arrValue, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> result : countArr.entrySet()) {
            if (result.getValue() > arr.length / 4) {
                return result.getKey();
            }
        }

        return -1;
    }

}
