package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1476
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int E = Integer.parseInt(token.nextToken()); //지구
        int S = Integer.parseInt(token.nextToken()); //태양
        int M = Integer.parseInt(token.nextToken()); //달

        int eCount =1; int sCount = 1; int mCount = 1;
        int year = 1;// 년도

        while (true)
        {
            if (eCount == E && sCount == S && mCount == M)
                break;
            ++year; ++eCount; ++sCount; ++mCount;

            if (eCount == 16)
                eCount = 1;
            if (sCount == 29)
                sCount = 1;
            if (mCount == 20)
                mCount = 1;
        }

        System.out.println(year);
    }
}
