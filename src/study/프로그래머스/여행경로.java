package study.프로그래머스;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN","SFO"} , {"ICN", "ATL"}, {"SFO","ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        Word[] words = new Word[tickets.length];

        for (int i=0; i<tickets.length; ++i)
            words[i] = new Word(tickets[i][0],tickets[i][1]);

        Arrays.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int r = o1.preWord.compareTo(o2.preWord);
                if (r != 0) return r;
                return o1.postWord.compareTo(o2.postWord);
            }
        });

        Queue<Word> queue = new LinkedList<>(Arrays.asList(words));

        List<String> list = new ArrayList<>();
        while (!queue.peek().preWord.equals("ICN"))
            queue.offer(queue.poll());

        String temp = "";
        list.add(queue.peek().preWord);
        list.add(queue.peek().postWord);

        temp = queue.poll().postWord;

        while (!queue.isEmpty()) {

            if (temp.equals(queue.peek().preWord)) {
                temp = queue.peek().postWord;
                list.add(queue.poll().postWord);
                continue;
            }

            queue.offer(queue.poll());
        }

        return list.toArray(new String[0]);
    }
}

class Word {
    String preWord;
    String postWord;

    public Word(String preWord, String postWord) {
        this.preWord = preWord;
        this.postWord = postWord;
    }
}