package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            String word = buffer.readLine();

            if (isPalindrome(word)) {
                System.out.println(0);
            } else {
                System.out.println(isSimilar(word));
            }
        }

    }

    private static boolean isPalindrome(String word) {
        int len = word.length() / 2;

        for (int i = 0, start = 0, end = word.length() - 1; i < len; ++i, ++start, --end) {
            if (word.charAt(start) != word.charAt(end))
                return false;
        }

        return true;
    }

    private static int isSimilar(String word) {
        int left = 0;
        int right = word.length() - 1;
        int count = 0;

        while (left <= right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                int l = left;
                int r = right;

                ++l;
                while (l <= r) {
                    if (word.charAt(l) != word.charAt(r)) {
                        ++count;
                        break;
                    }

                    ++l; --r;
                }

                l = left;
                r = right;

                --r;

                while (l <= r) {
                    if (word.charAt(l) != word.charAt(r)) {
                        ++count;
                        break;
                    }
                    ++l;
                    --r;
                }

                return count;
            }
        }

        return 0;
    }

}
