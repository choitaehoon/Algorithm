package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합분해 {

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = buffer.readLine().split(" ");
        int number = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        int[][] array = new int[201][201];

        array[0][0] = 1;
        for (int i=1; i<=k; ++i)
            array[0][i] = 1;

        for (int i=1; i<=number; ++i)
            for (int j=1; j<=k; ++j)
                array[i][j] = (array[i][j-1]+array[i-1][j]) % 1000000000;

        System.out.println(array[number][k]);
    }

}
