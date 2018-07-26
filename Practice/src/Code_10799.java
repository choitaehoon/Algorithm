import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Code_10799
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = buffer.readLine().split("");
        Stack<Integer> stack = new Stack<>();
        int sum =0 ;//쇠막대기를 셀 변수

        for (int i=0; i<temp.length; ++i)
        {
            if (temp[i].equals("("))
                stack.add(i);
            else if (temp[i].equals(")"))
            {
                if (i-stack.peek() == 1) //차이가 1이라는 것은 레이저
                {
                    stack.pop();
                    sum += stack.size();
                }
                else
                {
                    stack.pop();
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
