package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 무지의먹방라이브1 {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{3, 1, 2}, 5
        ));
    }

    public static int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<>();
        int length = food_times.length;

        for (int i = 0; i<length; ++i)
            foods.add(new Food(food_times[i], i + 1));

        foods.sort((a1, a2) -> a1.time - a2.time);

        int preTime = 0;
        int index = 0;

        for (Food food : foods) {
            long diff = food.time - preTime;

            if (diff != 0) {
                long spend = diff * length;

                if (spend <= k) {
                    k -= spend;
                    preTime = food.time;
                } else {
                    k %= length;
                    foods.subList(index, food_times.length).sort(
                            (a1, a2) -> a1.id - a2.id
                    );
                    return foods.get(index + (int)k).id;
                }
            }

            ++index;
            --length;
        }

        return -1;
    }

    static class Food {
        int time;
        int id;

        public Food(int time, int id) {
            this.time = time;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "time=" + time +
                    ", id=" + id +
                    '}';
        }
    }
}

/*

정렬 시키기


* */
