package 알고리즘기초.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 열개씩끊기 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String temp = buffer.readLine();
        int index = 0;

        for (int i=0; i<temp.length(); ++i) {
            System.out.print(temp.charAt(i));
            index = (index+1)%10;

            if (index == 0)
                System.out.println();
        }

    }
}
