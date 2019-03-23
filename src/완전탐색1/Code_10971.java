package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_10971
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int arrayNumber = Integer.parseInt(buffer.readLine());
        int[][] array = new int[arrayNumber][arrayNumber];

        for (int i=0; i<arrayNumber; ++i)
        {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<arrayNumber; ++j)
                array[i][j] = Integer.parseInt(token.nextToken());
        }

        int comparison = Integer.MAX_VALUE;
        int[] d = new int[arrayNumber-1];
        for (int i=0; i<arrayNumber-1; ++i)
            d[i] = i+1;


        do {
            boolean ok = true;
            int sum = 0;
            for (int i=0; i<arrayNumber-2; i++) {
                if (array[d[i]][d[i+1]] == 0)
                    ok = false;
                else
                    sum += array[d[i]][d[i+1]];
            }
            if (ok && array[0][d[0]] != 0 && array[d[arrayNumber-2]][0] != 0) {
                sum += array[0][d[0]] + array[d[arrayNumber-2]][0];
                comparison = Math.min(comparison, sum);
            }
        } while (permutation(d));
        System.out.println(comparison);
    }

    public static boolean permutation(int [] array)
    {
        int i = array.length-1;
        while (0<i && array[i-1] >= array[i])
            --i;

        if (i == 0) return false; //바꿀게 없다면

        int j = array.length-1;
        while (array[i-1] >= array[j])
            --j;

        swap(array, i-1, j);

        j = array.length-1;
        while (i<j)
            swap(array,i++,j--);
        return true;  // 성공시
    }

    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
