package KOI2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int line = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int sum = 0;

        int [] man = new int[6];
        int [] girl = new int[6];

        for (int i=0; i<line; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

            int sex = Integer.parseInt(tokenizer.nextToken());
            int grade = Integer.parseInt(tokenizer.nextToken());

            //여학생 이면
            if (sex == 0)
                girl[grade-1]++;

            //남학생이면
            else if (sex == 1)
                man[grade-1]++;
        }

        for (int i=0; i<6; ++i){
            if (girl[i] % k == 0)
                sum += girl[i] / k;
            else
                sum += (girl[i] / k) + 1;

            if (man[i] % k == 0)
                sum += (man[i] / k);
            else
                sum += (man[i] / k) + 1;
        }

        System.out.println(sum);
    }

}
