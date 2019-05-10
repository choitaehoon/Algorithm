package 알고리즘중급.자료구조2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

/*
* 시간 복잡도 -> O(n) -> 최대 출입 기록 수가 10만 이니까 / 변수 List<String>
*/

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        List<String> list = new ArrayList<>();

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            String name = token.nextToken();
            String accessibility = token.nextToken();

            if (accessibility.equals("enter")){
                list.add(name);
                continue;
            }

            list.remove(name);
        }

        sort(list);
        reverse(list);

        int listSize = list.size();
        for (int i=0; i<listSize; ++i)
            writer.write(list.get(i)+"\n");

        writer.close();
    }
}
