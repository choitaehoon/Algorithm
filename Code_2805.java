import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_2805
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int tree = Integer.parseInt(token.nextToken()); //나무의 수
        int length = Integer.parseInt(token.nextToken()); // 필요한 길이

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        int[] arr = new int[tree];

        for (int i=0; i<tree; ++i)
            arr[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.parallelSort(arr); //오름차순 정렬

        int min = 0; //최저 높이
        int max = arr[tree-1]; //최고 높이
        int middle = 0; //중간 값

        while (min <= max)
        {
            middle = (min+max)/2;
            int remain =0; //자르고 남은 길이
            long sum =0; //총 가져가는 길이

            for (int i=0; i<tree; ++i)
            {
                remain = arr[i] - middle;
                if (remain < 0) remain =0; //마이너스는 존재 x
                sum += remain;
            }

            if (length <= sum)
                min = middle+1;
            else
                max = middle-1;

        }

        System.out.println(max);
    }
}

