package 규칙찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 베르트랑공준 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();

        map.put(0,1);
        map.put(1,1);
        for (int i=2; i<=246912; ++i)
            if (map.get(i) == null)
                for (int j=i*2; j<=246912; j+= i)
                        map.put(j,1);


        int number;
        do {
            number = Integer.parseInt(buffer.readLine());
            int length = number*2;
            int count = 0;

            if (number != 0) {
                for (int i=number+1; i<=length; ++i)
                    if (map.get(i) == null)
                        ++count;
                System.out.println(count);
            }
        }while (number != 0);
    }

}
