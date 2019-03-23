package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2448
{
    static StringBuilder builder = new StringBuilder();
    static String[][] temp;

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        temp = new String[number][2*number-1];

        for (int i=0; i<number; ++i)
            for (int j=0; j<2*number-1; ++j)
                temp[i][j] = " ";

        search(number, 0, number-1);

        for (int i=0; i<number; ++i)
        {
            for (int j=0; j<2*number-1; ++j)
                builder.append(temp[i][j]);
            builder.append("\n");
        }
        System.out.println(builder);
    }

    public static void search(int number, int x, int y)
    {
        if (number == 3)
        {
            temp[x][y] = "*";
            temp[x+1][y-1] = "*";
            temp[x+1][y+1] = "*";
            temp[x+2][y-2] = "*";
            temp[x+2][y-1] = "*";
            temp[x+2][y] = "*";
            temp[x+2][y+1] = "*";
            temp[x+2][y+2] = "*";
            return;
        }



        search(number/2, x, y);
        search(number/2, x+number/2, y-number/2);
        search(number/2, x+number/2, y+number/2);
    }
}
