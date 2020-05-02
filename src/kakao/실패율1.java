package kakao;

import java.util.*;

public class 실패율1 {

    static Map<Integer, Integer> stageNumber = new HashMap<>();
    static Map<Integer, Double> failStage = new HashMap<>();
    static List<Map.Entry<Integer, Double>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
//        System.out.println(Arrays.toString(solution(
//                4, new int[]{4,4,4,4,4}
//        )));
    }

    public static int[] solution(int N, int[] stages) {

        for (int i=0; i<stages.length; ++i)
            stageNumber.put(stages[i], stageNumber.get(stages[i]) == null ? 1 : stageNumber.get(stages[i]) + 1);

        int stagePerson = stages.length;
        for (int i=1; i<=N; ++i) {
            if (!stageNumber.containsKey(i)) {
                failStage.put(i, 0.0);
                continue;
            } else {
                failStage.put(i, (double)stageNumber.get(i) / stagePerson);
            }

            stagePerson -= stageNumber.get(i);
        }

        result.addAll(failStage.entrySet());
        result.sort((a1, a2) -> {
            int r = a2.getValue().compareTo(a1.getValue());
            if (r != 0) return r;
            return  a1.getKey() - a2.getKey();
        });

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); ++i) {
            answer[i] = result.get(i).getKey();
        }

        return answer;
    }

}