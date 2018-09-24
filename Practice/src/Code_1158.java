import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_1158
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = buffer.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        int number = Integer.parseInt(temp[0]);
        int repetition = Integer.parseInt(temp[1]);

        for (int i=0; i<number; ++i) //큐에 삽입
            queue.add(i+1);

        System.out.print("<");
        for (int i=0; i<number; ++i)
        {
            for (int j =0; j<repetition-1; ++j)
                queue.add(queue.poll());
            if (number -1 != i)
            System.out.print(queue.poll()+", ");
            else
                System.out.print(queue.poll());
        }
        System.out.print(">");

    }
}
