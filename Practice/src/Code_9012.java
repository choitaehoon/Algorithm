import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
    empty()와 isEmpty()차이는 없다
    하지만 있는 이유는 JDK1.0 에서는 Collections프레임 워크가 없었다
    1.2로 버전이 업되면서 Collections프레임 워크가 생겨나고
    Collections의 stack에 isEmpty()를 구현했다
    결론 -> 아무거나 써도 상관x
*/
public class Code_9012
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        Stack<String> stack = new Stack<>();

        for (int i=0; i<n; ++i)
        {
            String[] temp = buffer.readLine().split("");
            for (int j=0; j<temp.length; ++j)
            {
                if (temp[j].equals("("))
                    stack.push(temp[j]);
                if(temp[j].equals(")") && stack.isEmpty())
                {
                    stack.push(temp[j]); //스택에 집어넣어서 아래코드에 NO 출력하기
                    break;
                }
                if (temp[j].equals(")") && !stack.isEmpty())
                    stack.pop();
            }
            if (stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }
//        Arrays.parallelSort();
    }
}
