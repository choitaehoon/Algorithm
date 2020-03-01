package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        String temp = token.nextToken();
        int essence= Integer.parseInt(token.nextToken());
        int sum = 0;
        int count =0;

        for (int i=temp.length()-1; i>=0; --i)
        {
            if ((int)temp.charAt(i)-48 < 10)
                sum += ((int)temp.charAt(i)-48) * (int)Math.pow(essence,count++);
            else
                sum += ((int)temp.charAt(i)-55) * (int)Math.pow(essence,count++);
        }

        System.out.println(sum);
    }

}
