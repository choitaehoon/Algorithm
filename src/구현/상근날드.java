package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상근날드 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int[] hamburger = new int[3];
        int[] beverage = new int[2];
        int index = 0;

        for (int i = 0; i < 5; ++i){
            if (i < 3)
                hamburger[i] = Integer.parseInt(buffer.readLine());
            else
                beverage[index++] = Integer.parseInt(buffer.readLine());
        }

        Arrays.sort(hamburger);
        Arrays.sort(beverage);

        System.out.println(hamburger[0] + beverage[0] - 50);
    }

}
