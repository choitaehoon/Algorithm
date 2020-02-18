package 문자열;

import java.util.LinkedList;
import java.util.Queue;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        for (int i=1; i<=s.length()/2; ++i) {
            Queue<Character> queue = new LinkedList<>();
            insertQueue(queue, s);
            actionQueue(queue, s, i);
        }

        return 0;
    }

    private static void insertQueue(Queue<Character> queue, String s) {
        for (int i=0; i<s.length(); ++i)
            queue.offer(s.charAt(i));
    }

    private static void actionQueue(Queue<Character> queue, String s, int index) {
        String temp = "";

        while (!queue.isEmpty()) {

            for (int i=0; i<index; ++i) {
                if (!queue.isEmpty())
                    temp += queue.poll();
            }

            if (checkCorrect(temp, queue, index)) {

            } else {
                temp = "";
            }

        }

    }

    private static boolean checkCorrect(String temp, Queue<Character> queue, int index) {
        String temp2 = "";

        for (int i=0; i<index; ++i) {
            if (!queue.isEmpty())
                temp2 += queue.poll();
        }

        System.out.println(temp+" "+temp2);
        return temp.equals(temp2);
    }

}
