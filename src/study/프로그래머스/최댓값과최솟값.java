package study.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }

    public static String solution(String s) {
        String[] temp = s.split(" ");
        List<Integer> list = new ArrayList<>();

        for (String data : temp)
            list.add(Integer.parseInt(data));

        Collections.sort(list);

        return list.get(0)+" "+list.get(list.size()-1);
    }
}
