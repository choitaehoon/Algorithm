import java.util.*;

public class StackTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        input.nextLine();
        for(int i=0; i<n; ++i)
        {
            String temp = input.nextLine();
            if(temp.equals("pop"))
                System.out.println(stack.empty() ? -1 : stack.pop());
            else if(temp.equals("size"))
                System.out.println(stack.size());
            else if(temp.equals("empty"))
                System.out.println(stack.empty() ? 1 : 0);
            else if(temp.equals("top"))
                System.out.println(stack.empty() ? -1 : stack.peek());
            else
            {
                String[] tt = temp.split(" ");
                stack.push(Integer.parseInt(tt[1]));
            }
        }

    }
}
