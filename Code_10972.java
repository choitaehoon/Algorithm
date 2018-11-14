import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Code_10972
{
    static int [] array;
    static List<Integer> temp;

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        array = new int[number]; //주어진 순열
        temp = new ArrayList<>(); //오름차순으로 받은 후에 Reverse ->맨 마지막 순열을 검사하기 위해
        if (search(number, token) == -1) { //마지막 검사
            System.out.println(-1);
            return;
        }
        permutation();
        StringBuilder builder = stringBuilder();
        System.out.println(builder);
    }

    public static void permutation()
    {
        int i = array.length-1;
        for (int k=i; k>=0; --k)
        {
            if (array[i] >= array[i-1])
                break;
            --i;
        }

        int j=array.length-1;
        for (int k=j; k>=0; --k)
        {
            if(array[j] >= array[i-1])
                break;
            --j;
        }
        swap(i-1,j);
        j = array.length-1;
        while (i<j)
        {
            swap(i,j);
            i++; j--;
        }
    }

    public static int search(int number, StringTokenizer token) //맨 마지막 순열 인지 검사
    {
        StringBuilder builderArray = new StringBuilder();
        StringBuilder builderTemp = new StringBuilder();
        for (int i=0; i<number; ++i)
        {
            int num = Integer.parseInt(token.nextToken());
            array[i] = num;
            temp.add(i+1);
            builderArray.append(num);
        }
        Collections.reverse(temp);
        for (int i=0; i<number; ++i)
            builderTemp.append(temp.get(i));

        if (builderArray.toString().equals(builderTemp.toString()))
            return -1;
        return 0;
    }
 
    public static void swap(int i, int j) //바꾸기
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
