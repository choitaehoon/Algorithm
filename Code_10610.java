import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_10610
{
    /*
    * 1. 0이 존재하는지 하고 각 수마다 더한 값이 3의 배수인지 확인한다
    * 2. 존재 하지 않는다면 바로 -1을 출력해준다
    * 3. 존재한다면 30배수가 존재한다는 의미로 정렬하고 뒤집은다음 StringBuilder를 사용해준다
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