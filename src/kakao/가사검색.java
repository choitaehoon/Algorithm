package kakao;

import java.util.*;

/*효율성 x*/
public class 가사검색 {

    static int sum;

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))
        );
    }

    public static int[] solution(String[] words, String[] queries) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> wordsList = new ArrayList<>(wordSet);
        List<String> queriesList = new ArrayList<>();

        for (String query : queries) {
            queriesList.add(query.replaceAll("[?]", "."));
        }

        wordsList.sort(String::compareTo);
        int len = queriesList.size();
        int wordLen = wordsList.size();
        List<Integer> store = new ArrayList<>();

        for (int i=0; i<len; ++i) {
            boolean[] isCheck = new boolean[wordLen];
            recursive(0, wordsList.size(), queriesList.get(i), wordsList, isCheck);
            store.add(sum);
            sum = 0;
        }

        int[] answer = new int[store.size()];
        for (int i=0; i<store.size(); ++i)
            answer[i] = store.get(i);

        return answer;
    }

    public static void recursive(int start, int end, String word, List<String> wordList, boolean[] isCheck) {
        int middle = (start + end) / 2;

        if (middle < 0 || middle >= wordList.size() || isCheck[middle])
            return;

        if (wordList.get(middle).matches(word)) {
            ++sum;
            isCheck[middle] = true;
        }

        if (start == end)
            return;

        recursive(start, middle, word, wordList, isCheck);
        recursive(middle+1, end, word, wordList, isCheck);
    }
}

