package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 코니와브라운 {

    static boolean[][] course = new boolean[200001][2];
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(solution(6, 3));
    }

    private static int solution(int cony, int brown) {
        return courseGo(cony, brown);
    }

    private static int courseGo(int cony, int brownIndex) {

        int time = 0;
        queue.offer(new Pair(brownIndex, 0));

        while (true) {
            cony += time;

            if (cony > 200000)
                return -1;
            if (course[cony][time % 2])
                return time;

            for (int i=0, size = queue.size(); i < size; ++i) {
                Pair pair = queue.poll();
                int currentPosition = pair.position;
                int newTime = (pair.time + 1) % 2;
                int newPosition ;

                newPosition = currentPosition - 1;
                if (0 <= newPosition && !course[newPosition][newTime]) {
                    course[newPosition][newTime] = true;
                    queue.offer(new Pair(newPosition, newTime));
                }

                newPosition = currentPosition + 1;
                if (newPosition <= 200000 && !course[newPosition][newTime]) {
                    course[newPosition][newTime] = true;
                    queue.offer(new Pair(newPosition, newTime));
                }

                newPosition = currentPosition * 2;
                if (newPosition <= 200000 && !course[newPosition][newTime]){
                    course[newPosition][newTime] = true;
                    queue.offer(new Pair(newPosition, newTime));
                }
            }

            ++time;
        }

    }
}

class Pair {

    int position;
    int time;

    public Pair(int position, int time) {
        this.position = position;
        this.time = time;
    }

}