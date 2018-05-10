package practice;

import java.util.Scanner;

public class 다트게임
{
    public static int sum(String temp) //Math.pow 메소드안에 temp.charAt(i-1) 하게 되면 문자를 읽어 버린다. 그 유니코드에 해당하는 문자를 숫자로 바꾸고 제곱하나 보다
    {
        int sum = 0;
        for(int i=0; i<temp.length(); ++i)
        {
            if(temp.charAt(i) == 'S')
            {
                sum += (int)Math.pow(Integer.parseInt(String.valueOf(temp.charAt(i-1))),1);
            }
            else if(temp.charAt(i) == 'D')
            {
                sum += (int)Math.pow(Integer.parseInt(String.valueOf(temp.charAt(i-1))),1);
            }
            else if(temp.charAt(i) == 'T')
            {
                sum += (int)Math.pow(Integer.parseInt(String.valueOf(temp.charAt(i-1))),1);
            }
            //옵션
            if(temp.charAt(i) == '#') //스타상 받을 경우
            {

            }
            if(temp.charAt(i) == '#') //아차상 받을 경우
            {

            }
        }
        return sum;

    }

    public static void main(String[] args)
    {
        System.out.println(sum("1D2S0T"));
        System.out.println(sum("1S2D*3T"));
    }
}
