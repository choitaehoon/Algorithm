package 그리디;

import java.util.*;

public class 체육복 {

    public static void main(String[] args) {
        System.out.println(solution(
                10,
                new int[]{5, 4, 3, 2, 1},
                new int[]{3, 1, 2, 5, 4}
        ));
    }

        public static int solution(int n, int[] lost, int[] reserve) {
            Arrays.sort(lost);
            Arrays.sort(reserve);
            Map<Integer, Boolean> lostMap = storeMap(lost);
            Map<Integer, Boolean> reserveMap = storeMap(reserve);
            boolean[] check = new boolean[n + 1];
            Arrays.fill(check, true);

            for (int i = 0; i < lost.length; ++i) {
                if (!reserveMap.containsKey(lost[i]))
                    check[lost[i]] = false;
            }

            for (int i = 0; i < reserve.length; ++i) {
                if (lostMap.containsKey(reserve[i])) {
                    continue;
                }

                if (reserve[i] - 1 > 0 && !check[reserve[i] - 1]) {
                    check[reserve[i] - 1] = true;
                } else if (reserve[i] + 1 <= n) {
                    if (!check[reserve[i] + 1])
                        check[reserve[i] + 1] = true;
                }
            }

            System.out.println(Arrays.toString(check));
            int answer = 0;
            for (int i = 1; i <= n; ++i)
                if (check[i])
                    answer++;

            return answer;
        }

        private static Map<Integer, Boolean> storeMap(int[] array) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < array.length; ++i)
                map.put(array[i], true);
            return map;
        }

}
