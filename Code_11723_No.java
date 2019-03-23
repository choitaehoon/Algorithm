import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Code_11723_No
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>(); //all 할때 순서대로 출력해야 하므로 TreeSet 선택
        int number = Integer.parseInt(buffer.readLine());
        int figure = 0;
        for (int i=0; i<number; ++i)
        {
            String[] temp = buffer.readLine().split(" ");
            String operation = temp[0]; if (temp.length == 2) figure = Integer.parseInt(temp[1]);
            if (operation.equals("add"))
                set.add(figure);
            else if (operation.equals("remove"))
                set.remove(figure);
            else if (operation.equals("check"))
                System.out.println(set.contains(figure) == true ? 1 : 0);
            else if (operation.equals("toggle"))
            {
                if (set.contains(figure) == true)
                    set.remove(figure);
                else
                    set.add(figure);
            }
            else if(operation.equals("all"))
                continue;
            else
            {
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext())
                    iterator.next();
                    iterator.remove();
            }

        }
    }
}