import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1780
{
    static int[][] array;
    static int minusZero;
    static int zero;
    static int one;
    /*
     * 배열에 집어 넣는 동안에 -1,0,1의 변수를 선언하고 그 수를 카운트 한다
     * 만약 하나의 수만 들어 있고 다른 수는 0이라면 모두 같은 수이므로 반환
     * 하지만 여러 수가 있으면 모두 같은 수가 아니므로 다시 초기화에서 카운트한다.(n은 n/3으로 해준다)
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
                int temp = Integer.parseInt(token.nextToken());
                array[i][j] = temp;
                if (temp == -1) minusZero++; if (temp == 0) zero++; if (temp == 1) one++;
            }
        }
        search(minusZero,zero,one);

    }

    public static void search(int mZero, int zer, int on)
    {
        if (mZero > 0 && zer == 0 && on == 0)
        {
            System.out.println(mZero);
            System.out.println(zer);
            System.out.println(on);
            return;
        }
        if (mZero == 0 && zer > 0 && on == 0)
        {
            System.out.println(mZero);
            System.out.println(zer);
            System.out.println(on);
            return;
        }
        if (mZero > 0 && zer == 0 && on > 0)
        {
            System.out.println(mZero);
            System.out.println(zer);
            System.out.println(on);
            return;
        }
        minusZero = zero = one = 0;
    }

}
