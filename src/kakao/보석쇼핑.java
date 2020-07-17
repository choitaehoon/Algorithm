package kakao;

import java.util.*;

public class 보석쇼핑 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(
//                new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}
//        )));
//        System.out.println(Arrays.toString(solution(
//                new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
//        )));
        System.out.println(Arrays.toString(solution(
                new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
        )));
    }

    public static int[] solution(String[] gems) {
        Set<String> rubyTotalCount = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> ruby = new HashMap<>();
        List<Pointer> resultStore = new ArrayList<>();

        int start = 0;
        int end = 0;
        int gemsLength = gems.length;
        int rubyTotalSize = rubyTotalCount.size();
        int rubyCount = 0;

        while (start < gemsLength) {

            if (rubyCount >= rubyTotalSize || end == gemsLength) {
                ruby.put(gems[start], ruby.get(gems[start]) - 1);

                if (ruby.get(gems[start]) == 0)
                    ruby.remove(gems[start]);

                ++start;
            } else {
                ruby.put(gems[end], ruby.getOrDefault(gems[end], 0) + 1);
                ++end;
            }

            rubyCount = ruby.size();

            if (rubyTotalSize == rubyCount) {
                resultStore.add(new Pointer(start + 1, end, end - (start + 1)));
            }
        }

        resultStore.sort((a1, a2) -> {
            int r = a1.distance - a2.distance;

            if (r != 0)
                return r;

            return a1.x - a2.x;
        });

        int[] answer = new int[2];
        answer[0] = resultStore.get(0).x;
        answer[1] = resultStore.get(0).y;
        return answer;
    }

}

class Pointer {
    int x;
    int y;
    int distance;

    public Pointer(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}