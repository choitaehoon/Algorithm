package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        int [][] array = new int[number+1][3];
        array[1][1] = 1;
        array[1][0] = 1;
        array[1][2] = 1;

        for (int i=2; i<=number; ++i) {
            array[i][0] = (array[i-1][1] + array[i-1][2] + array[i-1][0]) % 9901;
            array[i][1] = (array[i-1][0] + array[i-1][2]) % 9901;
            array[i][2] = (array[i-1][1] + array[i-1][0]) % 9901;
        }

        System.out.println( (array[number][0] + array[number][1] + array[number][2]) % 9901 );
    }
}
