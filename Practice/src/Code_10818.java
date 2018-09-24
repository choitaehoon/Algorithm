import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_10818
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        List<Integer> list = new ArrayList<>();
        String[] temp = buffer.readLine().split(" ");

        for (int i=0; i<n; ++i)
            list.add(Integer.parseInt(temp[i]));
        Collections.sort(list);
        System.out.printf("%d %d",list.get(0), list.get(list.size()-1));
    }
}
