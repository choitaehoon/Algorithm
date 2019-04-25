package 미해결문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수의연속합 {

    static Map<Integer,Integer> map = new HashMap<>();
    static List<Integer> minority = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        //소수 아닌거 찾기
        for (int i = 2; i <= givenNumber; ++i)
            if (map.get(i) == null)
                for (int j = i * 2; j <= givenNumber; j += i)
                    if (map.get(j) == null)
                        map.put(j, 1);

        int sum = 0;
        int count = 0;

        for (int i=2; i<=givenNumber; ++i) {
            if (map.get(i) == null) {
                if (sum < givenNumber) {
                    sum += i;
                    minority.add(i);
                }
                while (givenNumber <= sum) {
                        if (givenNumber == sum)
                            ++count;
                        sum -= minority.remove(0);
                }

            }
        }

        while (minority.size() != 0) {
            if (givenNumber == sum)
                ++count;
            sum -= minority.remove(0);
        }

        System.out.println(count);
    }
}
