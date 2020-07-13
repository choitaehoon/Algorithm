package TimeComplexity;

import java.util.HashMap;
import java.util.Map;

public class PermMissingElem {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Map<Integer, Boolean> aStore = new HashMap<>();
        int endNumber = A.length + 1;

        for (int value : A)
            aStore.put(value, true);

        for (int i = endNumber; i >= 0; --i)
            if (!aStore.containsKey(i))
                return i;

        return 0;
    }
}
