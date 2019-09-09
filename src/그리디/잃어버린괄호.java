package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] minusStore = buffer.readLine().split("-");
        List<Integer> plusStore = new ArrayList<>();

        for (String s : minusStore) {
            String[] plus = s.split("\\+");
            int sum = 0;
            for (String plus1 : plus) sum += Integer.parseInt(plus1);
            plusStore.add(sum);

        }

        int value = plusStore.get(0);
        for (int i=1; i<plusStore.size(); ++i)
                value -= plusStore.get(i);

        System.out.println(value);
    }

}