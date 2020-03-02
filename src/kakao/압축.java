package kakao;

import java.util.*;

public class 압축 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }

    public static int[] solution(String word) {
        Map<String, Integer> map = inputMap();
        List<Integer> list = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<word.length(); ++i) {
            builder.append(word.charAt(i));

            if (!map.containsKey(builder.toString())) {
                map.put(builder.toString(), map.size() + 1);
                builder.setLength(builder.length()-1);
                list.add(map.get(builder.toString()));
                builder.setLength(0);
                --i;
            }
        }

        //edge case
        if (builder.length() > 0)
            list.add(map.get(builder.toString()));

        int[] array = new int[list.size()];
        for (int i=0; i<list.size(); ++i)
            array[i] = list.get(i);

        return array;
    }

    private static Map<String, Integer> inputMap() {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<26; ++i)
            map.put(Character.toString((char)(65 + i)), i + 1);

        return map;
    }

}

