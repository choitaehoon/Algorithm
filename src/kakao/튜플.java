package kakao;

import java.util.*;

public class 튜플 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        )));
    }

    public static int[] solution(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length() - 1);

        String temp = builder.toString().replace("{", "");
        String[] store = temp.split("},");

        for (int i=0; i<store.length; ++i) {
            store[i] = store[i].replace("}", "");
        }

        Arrays.sort(store, (a1, a2) -> a1.length() - a2.length());

        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0; i<store.length; ++i) {
            String result = store[i].replace("}", "");
            String[] resultArray = result.split(",");

            for (int z = 0; z<resultArray.length; ++z)
                set.add(Integer.parseInt(resultArray[z]));
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()){
            answer[index++] = iterator.next();
        }

        return answer;
    }
}
