package KOI2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        char[] bowl = buffer.readLine().toCharArray();
        int height = 10;


        for (int i=1; i<bowl.length; ++i) {
            if (bowl[i-1] == bowl[i])
                height += 5;

            else if (bowl[i-1] != bowl[i])
                height += 10;
        }

        System.out.println(height);
    }
}
