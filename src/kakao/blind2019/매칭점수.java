package kakao.blind2019;

//ing
public class 매칭점수 {

    public static void main(String[] args) {

    }

    public int solution(String word, String[] pages) {
        int pageLength = pages.length;

        for (int i = 0; i < pageLength; ++i) {
            int defaultSum = wordCount(word, pages[i]);
        }

        int answer = 0;
        return answer;
    }

    private int wordCount(String word, String page) {
        String[] wordArray = page.split("[^a-zA-Z]");
        int count = 0;
        int wordLength = wordArray.length;

        for (int i = 0; i < wordLength; ++i) {
            if (word.equalsIgnoreCase(wordArray[i]))
                ++count;
        }

        return count;
    }
}
