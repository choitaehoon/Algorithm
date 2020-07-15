package CountingElements;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {

        Map<Integer, Integer> aStoreNumber = new HashMap<>();

        for (int value : A)
            aStoreNumber.put(value, aStoreNumber.get(value) == null ? 1 : aStoreNumber.get(value) + 1);

        for (int i = 1; i <= A.length; ++i) {
            if (!aStoreNumber.containsKey(i) || aStoreNumber.get(i) != 1)
                return 0;
        }

        return 1;
    }

}
