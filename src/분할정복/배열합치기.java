package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        StringTokenizer tokenA = new StringTokenizer(buffer.readLine());
        StringTokenizer tokenB = new StringTokenizer(buffer.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        int[] array = new int[a+b];

        int tokenALength = tokenA.countTokens();
        for (int i=0; i<tokenALength; ++i)
            array[i] = Integer.parseInt(tokenA.nextToken());

        int tokenBLength = tokenB.countTokens();
        for (int i=tokenALength; i<tokenBLength+tokenALength; ++i)
            array[i] = Integer.parseInt(tokenB.nextToken());

        Arrays.sort(array);

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<a+b; ++i)
            builder.append(array[i]).append(" ");

        System.out.println(builder);
    }

}
