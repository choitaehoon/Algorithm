package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 골드바흐의추측소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=2; i<=10000; ++i)
            if (map.get(i) == null)
                for (int j=i*2; j<=10000; j+=i)
                    if (map.get(j) == null)
                        map.put(j,1);

        int givenNumber = Integer.parseInt(buffer.readLine());
        for (int i=0; i<givenNumber; ++i) {
            int num = Integer.parseInt(buffer.readLine());
            int moveMinus = num-2;

            int number1 =0;
            int number2 =0;
            int min = Integer.MAX_VALUE;

            for (int j=2; j<=num-2; ++j) {
                if (j > moveMinus)
                    break;

                if (map.get(j) == null && map.get(moveMinus) == null){
                    if (min > Math.abs(j-moveMinus)) {
                        number1 = j;
                        number2 = moveMinus;
                    }
                }
                --moveMinus;
            }
            System.out.println(number1+" "+number2);
        }

    }
}
