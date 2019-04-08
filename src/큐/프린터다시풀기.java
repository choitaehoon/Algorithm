package 큐;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터다시풀기 {
    public static void main(String[] args) {
        int[]priorities = {2, 1, 3, 2};
//        int[]priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<QueueGroup> queue = new LinkedList<>();

        for (int i=0; i<priorities.length; ++i)
            queue.offer(new QueueGroup(priorities[i],i));

        while (!queue.isEmpty()) {
            if (checkMoreImportance(queue)) {
                if (queue.poll().location != location)
                     ++answer;
                else
                    return answer;
            }

        }

        return answer;
    }

    public static boolean checkMoreImportance (Queue<QueueGroup> groups) {
        Iterator<QueueGroup> iterator = groups.iterator();
        int now = iterator.next().importance;

        while (iterator.hasNext()) {
            int next = iterator.next().importance;
            if (now < next) {
                groups.offer(groups.poll());
                return false;
            }
        }

        //나보다 큰게 없다면
        return true;
    }

}

class QueueGroup{
    int importance;
    int location;

    public QueueGroup(int importance, int location) {
        this.importance = importance;
        this.location = location;
    }
}