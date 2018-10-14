import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_2263
{
    /*
     *프리오더 -> 전위 순회 // 인오더 -> 중위 순회 // 포스트오더 -> 후위 순회
     * 이 문제는 중위 순회와 후위 순회를 주고 전위 순회를 알게 하는 문제.
     */
    static StringBuilder builder = new StringBuilder();
    static int[] inOrder; static int[] postOrder;
    static int[] value;
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        inOrder = new int[number];
        postOrder = new int[number];
        value = new int[number+1];

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        for(int i=0; i<number; ++i)
        {
            inOrder[i] = Integer.parseInt(token.nextToken());
            value[inOrder[i]] = i;
        }

        StringTokenizer token2 = new StringTokenizer(buffer.readLine());
        for (int i=0; i<number; ++i)
            postOrder[i] = Integer.parseInt(token2.nextToken());
        search(0, number-1, 0, number-1);
        System.out.println(builder);
    }

    public static void search(int inOrderFirst, int inOrderLast, int postFirst, int postLast)
    {
        if (inOrderFirst > inOrderLast || postFirst > postLast) return;
        int root = postOrder[postLast];
        builder.append(root).append(" ");

        search(inOrderFirst,value[root] -1, postFirst, postFirst+value[root]-inOrderFirst-1);
        search(value[root]+1,inOrderLast,value[root]-inOrderFirst+postFirst, postLast-1);
    }
}
