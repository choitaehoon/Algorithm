package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_10973
{
    static int [] array;
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        array = new int[number];
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        for (int i=0; i<array.length; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        if (search()){
            System.out.println(-1);
            return;
        }
        StringBuilder builder = stringBuilder();
        System.out.println(builder);
    }

    public static boolean search()
    {
        int i = array.length-1;
        while (0 <i)
        {
            if (array[i] < array[i-1])
                break;
            --i;
        }
        if (i == 0) //바꿀게 없으므로 -> 맨마지막이라는 뜻
            return true;

        int j = array.length-1;
        while (0 < j)
        {
            if (array[i-1] > array[j])
                break;
            --j;
        }
        swap(i-1,j);
        j = array.length-1;
        while (i<j)
        {
            swap(i,j);
            ++i;--j;
        }
        return false;
    }

    public static void swap(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static StringBuilder stringBuilder()
    {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<array.length; ++i)
            builder.append(array[i]).append(" ");
        return builder;
    }
}
