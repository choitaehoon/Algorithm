package kakao.blind2019;

import java.util.*;

public class 실패율 {

    static Map<Integer, Integer> stageCount = new HashMap<>();
    static Map<Integer, Double> failStage = new HashMap<>();
    static List<Map.Entry<Integer, Double>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                5,
                new int[]{2, 1, 2, 6, 2, 4, 3, 3}
        )));
    }

    public static int[] solution(int N, int[] stages) {
        int personLength = stages.length;

        for (int value : stages)
            stageCount.put(value, stageCount.getOrDefault(value, 0) + 1);

        for (int i = 1; i <= N; ++i) {
            if (!stageCount.containsKey(i)) {
                failStage.put(i, 0.0);
                continue;
            }

            failStage.put(i, (double)stageCount.get(i) / personLength);
            personLength -= stageCount.get(i);
        }

        resultList.addAll(failStage.entrySet());
        resultList.sort((a1, a2) -> {
            int r = a2.getValue().compareTo(a1.getValue());

            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });

        int[] answer = new int[resultList.size()];
        for (int i = 0; i <resultList.size(); ++i)
            answer[i] = resultList.get(i).getKey();
        return answer;
    }

}
