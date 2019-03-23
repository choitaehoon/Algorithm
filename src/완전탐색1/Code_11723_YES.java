package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_11723_YES
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        StringBuilder builder = new StringBuilder(); //시간초과 나므로

        int figure = 0; //수 담기
        int change = 0; //반복문 마다 받는 변수

        for (int i=0; i<number; ++i)
        {
            String[] temp = buffer.readLine().split(" ");
            String calculator = temp[0]; if (temp.length == 2) change = Integer.parseInt(temp[1]);

            if (calculator.equals("add"))
                figure = figure | (1 << change);
            else if (calculator.equals("remove"))
                figure = figure & ~(1 << change);
            else  if (calculator.equals("check"))
            {
                if ((figure & (1 << change) ) > 0 )// 존재 하면 -> 원래1로 했는데 존재하면 그 수를 반환하므로 >0으로 함
                    builder.append(1).append("\n");
                else //존재 하지 않는 다면
                    builder.append(0).append("\n");
            }
            else if(calculator.equals("toggle"))
                figure = figure ^ (1 << change);
            else if (calculator.equals("all"))
                figure = ((1 << 21)-1) & ~(1); //전체수가 21개이므로 21개 지정함
            else if (calculator.equals("empty"))
                figure =0;
        }
        System.out.println(builder);
    }
}