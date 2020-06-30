package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        Map<String, Boolean> nMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            nMap.put(buffer.readLine(), true);

        for (int i = 0; i < m; ++i) {
            String word = buffer.readLine();
            if (nMap.containsKey(word)) {
                resultList.add(word);
            }
        }

        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (String s : resultList)
            System.out.println(s);
    }

}
