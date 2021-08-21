package leetcode.string;

public class Main_1668 {

    public static void main(String[] args) {
        System.out.println(maxRepeating(
                "aaabaaaabaaabaaaabaaaabaaaabaaaaba",
                "aaaba"
        ));
    }

    public static int maxRepeating(String sequence, String word) {
        int len = word.length();
        int count = 0;
        int result = 0;

        for (int i = 0; i < sequence.length(); ) {
            int row = Math.min(i + len, sequence.length());
            String nowWord = sequence.substring(i, row);

            if (nowWord.equals(word)) {
                ++count;
                i += len;
            } else {
                result = Math.max(result, count);
                count = 0;
                i++;
            }
        }


        //모두 같은 문자열일 때
        if (count != 0) {
            result = Math.max(result, count);
        }

        count = 0;

        for (int i = sequence.length(); i >= 0; ) {
            int row = Math.max(i - len, 0);
            String nowWord = sequence.substring(row, i);

            if (nowWord.equals(word)) {
                ++count;
                i -= len;
            } else {
                result = Math.max(result, count);
                count = 0;
                i--;
            }
        }

        //모두 같은 문자열일 때
        if (count != 0) {
            result = Math.max(result, count);
        }

        return result;
    }

    public int maxRepeating2(String sequence, String word) {
        int count = 0;
        String compareWord = word;

        while (sequence.contains(compareWord)) {
            ++count;
            compareWord += word;
        }

        return count;
    }

}
