package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 농구경기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        Map<Character, Integer> personNumber = new HashMap<>();
        for (int i = 0; i < givenNumber; ++i) {
            String personWord = buffer.readLine();
            personNumber.put(personWord.charAt(0), personNumber.get(personWord.charAt(0)) == null ?
                    1 : personNumber.get(personWord.charAt(0)) + 1);
        }

        List<Map.Entry<Character, Integer>> personList = new ArrayList<>(personNumber.entrySet());
        personList.sort((a1, a2) -> a1.getKey() - a2.getKey());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < personList.size(); ++i) {
            if (personList.get(i).getValue() >= 5)
                builder.append(personList.get(i).getKey());
        }

        if (builder.toString().isEmpty()) {
            System.out.println("PREDAJA");
        } else
            System.out.println(builder);
    }

}
