package 구현;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{2, 1, 1, 3}
        ));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> aStore = new HashMap<>();
        int aLengthHalf = A.length / 2;
        int key = -1;

        for (int value : A) {
            aStore.put(value, aStore.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> maps : aStore.entrySet()) {
            if (aLengthHalf < maps.getValue()) {
                key = maps.getKey();
                break;
            }
        }

        if (key == - 1) {
            return -1;
        } else {
            for (int i = 0; i < A.length; ++i) {
                if (key == A[i]) {
                    key = i;
                    break;
                }
            }
        }

        return key;
    }

}
