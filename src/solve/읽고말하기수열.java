package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 읽고말하기수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] storeSequence = buffer.readLine().split(" ");
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < storeSequence.length - 1; ++i) {
            sequence.add(Integer.parseInt(storeSequence[i]));
        }

        int now;
        int next = 0;
        int count = 1;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < sequence.size(); ++i) {
            now = next;
            next = sequence.get(i);

            if (now == next) {
                ++count;
            } else {
                if (now == 0)
                    continue;

                builder.append(count).append(" ").append(now).append(" ");
                count = 1;
            }
        }

        builder.append(count).append(" ").append(next).append(" ");

        System.out.println(builder);
    }

}
