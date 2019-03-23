package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2447
{
    /* 분할 정복 문제 */
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());

        for(int i=0; i<number; ++i)
        {
            for (int j=0; j<number; ++j)
                search(number,i,j);
            builder.append("\n");
        }

    }

    public static void search(int number, int i, int j)
    {
        if ((i/number) % 3 == 1 && (j/number) % 3 == 1)
            builder.append(" ");
        else
        {
            if (number/3 ==0)
                builder.append("*");
            else
                search(number/3,i,j);
        }
    }
}
