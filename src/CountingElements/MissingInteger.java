package CountingElements;

import java.util.HashMap;
import java.util.Map;

public class MissingInteger {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Map<Integer, Boolean> aKeyStore = new HashMap<>();

        for (int value : A)
            aKeyStore.put(value, true);

        for (int i = 1; i <= 1_000_000; ++i) {
            if (!aKeyStore.containsKey(i)) {
                return i;
            }
        }

        return 1;
    }

}
