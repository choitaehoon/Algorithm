package leetcode.string;

import java.util.*;

public class Main_648 {

    public static String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        int len = dictionary.size();
        String[] sen = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : sen) {
            String temp = "";

            for (int i = 0; i < len; ++i) {
                String dicWord = dictionary.get(i);
                if (word.length() < dicWord.length()) continue;

                String word1 = word.substring(0, dicWord.length());

                if (word1.equals(dicWord)) {
                    temp = dicWord;
                    break;
                }
            }

            result.append(temp.length() == 0 ? word : temp).append(" ");
        }

        return result.toString().trim();
    }


}
