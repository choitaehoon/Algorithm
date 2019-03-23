package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_9095
{
    public static int recursiveNumber(int number, int[] array)
    {
        if (number == 0) return array[number]; if (number == 1) return array[number];
        if (number == 2) return array[number]; if (number == 3) return array[number];
        if (array[number] > 0) return array[number];
        array[number] = recursiveNumber(number-1,array) + recursiveNumber(number-2,array) + recursiveNumber(number-3,array);
        return array[number];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(buffer.readLine());
        int[] array = new int[11];
        array[0] = 0; array[1] = 1; array[2] = 2; array[3] = 4;

        for (int i=0; i<repeat; ++i)
            System.out.println(recursiveNumber(Integer.parseInt(buffer.readLine()),array));
    }
}
