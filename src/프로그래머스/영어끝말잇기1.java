package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}
                )));
//        System.out.println(Arrays.toString(solution(
//                2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}
//        )));
    }

    private static int[] solution(int person, String[] words) {
        int[] result = new int[2];
        Map<String, Boolean> storeWord = new HashMap<>();
        boolean isContainsKey = false;
        int order = 0;
        int id = 0;
        char preWord = ' ';

        for (int i = 0; i < words.length; ++i) {
            if (i == 0) {
                storeWord.put(words[i], true);
            } else if (preWord != words[i].charAt(0) || storeWord.containsKey(words[i])) {
                isContainsKey = true;
                id = i % person + 1;
                order = i / person + 1;
                break;
            } else if (!storeWord.containsKey(words[i])) {
                storeWord.put(words[i], true);
            } else if (i == words.length - 1) {
                isContainsKey = true;
                break;
            }

            preWord = words[i].charAt(words[i].length() - 1);
        }

        if (isContainsKey) {
            result[0] = id;
            result[1] = order;
        } else {
            Arrays.fill(result, 0);
        }

        return result;
    }

}
