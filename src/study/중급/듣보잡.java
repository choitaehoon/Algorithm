package study.중급;

import java.io.*;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int givenN = Integer.parseInt(token.nextToken());
        int givenM = Integer.parseInt(token.nextToken());
        int nPlusM = givenN + givenM;

        Map<String,Integer> map = new HashMap<>();
        List<String> temp = new ArrayList<>();

        for (int i=0; i<nPlusM; ++i) {
            String keyword = buffer.readLine();
            if (i < givenM){
                map.put(keyword,1);
                continue;
            }

            if (map.get(keyword) != null)
                temp.add(keyword);
        }

        Collections.sort(temp);
        System.out.println(temp.size());
        for (int i=0; i<temp.size(); ++i)
            writer.write(temp.get(i)+"\n");
        writer.close();
    }
}
