package leetcode.string;

import java.io.IOException;
import java.util.*;

public class Main_1496 {

    static Map<Character, String> store = new HashMap<>();

    static {
        store.put('N', "-1 0");
        store.put('S', "1 0");
        store.put('E', "0 1");
        store.put('W', "0 -1");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isPathCrossing(
                "NESWW"
        ));
    }

    public static boolean isPathCrossing(String path) {
        Map<String, Boolean> maps = new HashMap<>();
        char[] array = path.toCharArray();
        int x = 0;
        int y = 0;
        maps.put("0 0", true);

        for (int i = 0; i < array.length; ++i) {
            char word = array[i];
            String[] temp = store.get(word).split(" ");
            int xPlus = Integer.parseInt(temp[0]);
            int yPlus = Integer.parseInt(temp[1]);

            int xGo = x + xPlus;
            int yGo = y + yPlus;

            if(maps.containsKey(xGo +" "+ yGo)) {
                return true;
            } else {
                maps.put(xGo+" "+yGo, true);
                x = xGo;
                y = yGo;
            }
        }

        return false;
    }
}
