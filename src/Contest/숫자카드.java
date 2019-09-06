package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();

        int givenNumber = Integer.parseInt(buffer.readLine());
        StringTokenizer token1 = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            map.putIfAbsent(Integer.parseInt(token1.nextToken()), 1);

        int cardCheck = Integer.parseInt(buffer.readLine());
        StringTokenizer token2 = new StringTokenizer(buffer.readLine());

        for (int i=0; i<cardCheck; ++i)
            System.out.print(map.get(Integer.parseInt(token2.nextToken())) == null ? 0+" " : 1+" ");
    }

}
