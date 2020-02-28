package kakao;

import java.util.*;

public class 실패율 {

    static List<Map.Entry<Integer, Double>> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public static int[] solution(int N, int[] stages) {

        List<Integer> stageStore = stageStoreAdd(stages);
        Map<Integer, Double> map = new HashMap<>();
        boolean[] isCheck = new boolean[stages.length];
        int len = stageStore.size();

        for (int i=1; i<=N; ++i) {
            int sum = 0;

            for (int j=0; j<stageStore.size(); ++j) {
                if (i >= stageStore.get(j) && !isCheck[j]) {
                    ++sum;
                    isCheck[j] = true;
                }
            }

            if (sum == 0 && len == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double)sum / len);
            }
            len -= sum;
        }

        list.addAll(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                int r = o2.getValue().compareTo(o1.getValue());
                if (r == 0)
                    return o1.getKey() - o2.getKey();
                return r;
            }
        });

        int[] answer = new int[list.size()];
        int i =0;

        for (Map.Entry<Integer, Double> maps : list) {
            answer[i++] = maps.getKey();
        }

        return answer;
    }

    private static List<Integer> stageStoreAdd(int[] stages) {
        List<Integer> store = new ArrayList<>();

        for (int stage : stages)
            store.add(stage);

        return store;
    }

}
