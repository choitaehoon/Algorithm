package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1780
{
    static int[][] array;
    static int minusOne; static int zero; static int one;
    static int minusOneSum; static int zeroSum; static int oneSum;
    /*
     * -1,0,1의 변수를 선언하고 배열에 집어 넣는 동안에 3개의 변수를 카운트 한다
     * 만일 하나만 값이 있고 다른게 없다면 그대로 출력하고 종료.
     * 하지만 값이 세 변수가 다르다면 givenNumber/3를 해준다.
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine()); //주어진 수
        array = new int[number][number];

        for (int i=0; i<number; ++i)
        {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for (int j=0; j<number; ++j)
            {
                int search = Integer.parseInt(token.nextToken());
                array[i][j] = search;
            }
        }
        aThird(0,0,number);
        System.out.println(minusOneSum);
        System.out.println(zeroSum);
        System.out.println(oneSum);
    }

    public static boolean same(int x, int y, int size)
    {
        for (int i=x; i< x+size; ++i)
            for (int j=y; j<y+size; ++j)
                count(array[i][j]);
        if (search()) return true;
        return false;
    }

    //쪼개는 메소드
    public static void aThird(int x, int y, int number)
    {
        if (same(x,y,number))
            return;

            for (int i=0; i<3; ++i)
                for (int j=0; j<3; ++j)
                    aThird(x+i*(number/3), y+j*(number/3), number/3);
    }

    //변수 카운트 증가
    public static void count(int search)
    {
        if (search == -1) minusOne++;
        if (search == 0) zero++;
        if (search == 1) one++;
    }

    /*
     *검사하는 메소드
     * 만일 이 검사에 조건문이 안들어가면 더 쪼갤 수 있는 상황
     * 쪼갠 후 에 다시 검사하려면 변수 다 초기화
     */
    public static boolean search()
    {
        if (minusOne > 0 && zero == 0 && one ==0)
        {
            ++minusOneSum;
            minusOne = zero = one =0;
            return true;
        }
        if (minusOne == 0 && zero > 0 && one == 0)
        {
            ++zeroSum;
            minusOne = zero = one =0;
            return true;
        }
        if (minusOne == 0 && zero == 0 && one >0)
        {
            ++oneSum;
            minusOne = zero = one =0;
            return true;
        }
        minusOne = zero = one =0;
        return false;
    }
}