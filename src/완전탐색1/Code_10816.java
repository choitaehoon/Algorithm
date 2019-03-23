package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Code_10816
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());//상근이가 가지고 있는 카드 수
        Map<Integer,Integer> maps = new HashMap<>(); //카드 저장 할 맵
        StringTokenizer token = new StringTokenizer(buffer.readLine()); //카드

        for (int i=0; i<number; ++i)
        {
            int temp = Integer.parseInt(token.nextToken());
            maps.put(temp, maps.get(temp) == null ? 1 : maps.get(temp)+1);
        }

        int cards = Integer.parseInt(buffer.readLine()); // 주어진 카드 수
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<cards; ++i)
        {
            int temp = Integer.parseInt(tokenizer.nextToken());
            if (maps.get(temp) == null)
                builder.append(0).append(" ");
            else
                builder.append(maps.get(temp)).append(" ");
        }

        System.out.println(builder);

    }
}
