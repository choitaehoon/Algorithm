package kakao;

import java.util.*;

public class 무지의먹방라이브 {

    public static void main(String[] args) {

    }

    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int length = food_times.length;

        for (int i=0; i<length; ++i) {
            foods.add(new Food(food_times[i], i + 1));
        }

        foods.sort((a1, a2) -> {
            return a1.time - a2.time;
        });

        int preTime = 0;
        int i = 0;

        for (Food food : foods) {
            long diff = food.time - preTime;
            if (diff != 0) {
                long spend = diff * length;
                if (spend <= k) {
                    k -= spend;
                    preTime = food.time;
                } else {
                    k %= length;
                    foods.subList(i, food_times.length).sort(
                            (a1, a2) -> {
                                return a1.id - a2.id;
                            }
                    );
                    return foods.get(i + (int)k).id;
                }
            }
            ++i;
            --length;
        }

        return -1;
    }

    class Food {
        int time;
        int id;

        public Food(int t, int i) {
            time = t;
            id = i;
        }
    }
}
