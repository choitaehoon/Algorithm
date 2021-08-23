package leetcode.string;

import java.util.*;
import java.math.*;


public class Main_1805 {

    public int numDifferentIntegers(String word) {
        String[] store = word.split("[a-z]+");
        Map<BigInteger, Boolean> map = new HashMap<>();

        for (int i = 0; i < store.length; ++i) {
            if (!store[i].equals("")) {
                map.put(new BigInteger(store[i]), true);
            }
        }

        return map.size();
    }

}
