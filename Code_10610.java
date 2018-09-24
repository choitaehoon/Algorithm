import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_10610
{
    /*
    * 1.수가 주어지면 각 경우의 수를 계산해야 한다.
    * 2.각 경우의 수를 계산 했는데 없다면 -1 (각 경우의 수 중 0이 있다면 맨앞으로 x)
    * 3.각 경우의 수 중 몇가지가 있다면 큰 수를 계산한다.
    */
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = buffer.readLine().split("");
        List<Integer> list = new ArrayList<>();
        int sum=0;
        boolean zero = false;

        for (int j=0; j<temp.length; ++j)
        {
            if (Integer.parseInt(temp[j]) == 0)
                zero = true;
            list.add(Integer.parseInt(temp[j]));
            sum += Integer.parseInt(temp[j]);
        }

        Collections.sort(list);
        Collections.reverse(list);

        if (sum % 3 != 0 || !zero) //30배수 걸러냄
        {
            System.out.println(-1);
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (int j=0; j<list.size(); ++j)
            builder.append(list.get(j));

        System.out.println(builder);
    }
}