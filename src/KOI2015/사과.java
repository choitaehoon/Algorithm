package KOI2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int school = Integer.parseInt(buffer.readLine());
        int sum = 0;

        for (int i=0; i<school; ++i){
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int people = Integer.parseInt(token.nextToken());
            int apple = Integer.parseInt(token.nextToken());

            if (isBLarger(people,apple))
                sum += distributeApples(people,apple);
            else
                sum += apple;
        }

        System.out.println(sum);
    }

    //사람이 더 많으면 합을 안더하는 메소드
    private static boolean isBLarger(int people, int apple){
        return people <= apple;
    }

    //사과를 나눠주는 메소드
    private static int distributeApples(int people, int apple){
        return apple % people;
    }

}
