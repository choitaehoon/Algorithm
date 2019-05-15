package study.중급;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int givenNumber = Integer.parseInt(buffer.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());

            String name = token.nextToken();
            String accessibility = token.nextToken();

            if (accessibility.equals("leave")) {
                map.remove(name);
                continue;
            }
            map.put(name,1);
        }

        for (Map.Entry<String,Integer> maps : map.entrySet())
            list.add(maps.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        int listLength = list.size();
        for (int i=0; i<listLength; ++i)
            writer.write(list.get(i)+"\n");
        writer.close();
    }
}
