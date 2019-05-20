package 프로그래머스;

import java.util.*;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
//        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    public static int[] solution(int n, String[] words) {

        int failPerson = 0;
        int failCount = 0;
        int wordsLength = words.length;
        Map<String, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        boolean check = false;

        for (int i=0; i<wordsLength; ++i) {

            failPerson = i % n;
            failCount = i / n;

            if (!queue.isEmpty() && queue.peek() != words[i].charAt(0)) {
                check = true;
                break;
            }
            if (!queue.isEmpty())
                queue.poll();

            if (map.get(words[i]) != null) {
                check = true;
                break;
            }
            else
                map.put(words[i], 1);

            queue.offer(words[i].charAt(words[i].length()-1));
        }

        return check ? new int[]{failPerson+1,failCount+1} : new int[]{0,0};
    }
}
