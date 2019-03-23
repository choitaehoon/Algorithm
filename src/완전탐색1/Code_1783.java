package 완전탐색1;

import java.io.*;
import java.util.StringTokenizer;

public class Code_1783
{
    /*
     * 세로와 가로가 주어질 수 있는 수가 20억이기 때문에 for문으로 접근하면 안된다.
     * 경우의 수를 나누어 풀어야 한다.
     * height = 1 , height = 3, height = 7
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int y = Integer.parseInt(token.nextToken()); //세로
        int x = Integer.parseInt(token.nextToken()); //가로
        int sum = 0; //이동 횟수

        if (y == 1)
            sum += 1;
        else if (y == 2)
            sum = Math.min(4,(x+1)/2);
        else
        {
            if (x < 7)
                sum = Math.min(4,x);
            else if (x == 7)
                sum = 5;
            else
                sum = x-2;
        }

        System.out.println(sum);
    }
}
