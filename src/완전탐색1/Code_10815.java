package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_10815
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine()); //상근이의 숫자 카드 개수
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        Map<Integer, Integer> maps = new HashMap<>(); //카드 적혀 있는 숫자

        for (int i=0; i<number; ++i)
            maps.put(Integer.parseInt(token.nextToken()), 1);

        int cards = Integer.parseInt(buffer.readLine()); //가지고 있는 개수
        StringTokenizer tokens = new StringTokenizer(buffer.readLine()); // 검사 할 카드
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<cards; ++i)
        {
            int temp = Integer.parseInt(tokens.nextToken());
            if (maps.get(temp) == null)
                builder.append(0).append(" ");
            else
                builder.append(1).append(" ");
        }
        System.out.println(builder);


    }
}
