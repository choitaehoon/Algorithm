import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1080
{

    /*
     * split과 StringTokenizer의 차이
     * split은 String클래스의 메소드로 추출한 문자를 배열로 저장
     * StringTokenizer는 메소드가 아니라 java.util에 포함하는 자체 클래스
     */
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int sum = 0;

        a = new int[n][m];
        b = new int[n][m];

        for (int i=0; i<n; ++i) //a배열 삽입
        {
            String[] temp = buffer.readLine().split("");
            for (int j=0; j<m; ++j)
                a[i][j] = Integer.parseInt(temp[j]);
        }

        for (int i=0; i<n; ++i) //b배열 삽입
        {
            String[] temp = buffer.readLine().split("");
            for (int j=0; j<m; ++j)
                b[i][j] = Integer.parseInt(temp[j]);
        }

        if ((n < 3 && m < 3) || (n <=3 && m <3) || (n <3 && m <=3)) //바꿀 수 없는 경우
        {
            for (int i=0; i<n; ++i)
                for (int j=0; j<m; ++j)
                    if (a[i][j] != b[i][j])
                    {
                        System.out.println(-1);
                        return;
                    }
            System.out.println(0);
            return;
        }

        for (int i=0; i<n-2; ++i)
            for (int j=0; j<m-2; ++j)
                if (a[i][j] != b[i][j])
                {
                    ++sum;
                    for (int k=i; k<=i+2; ++k)
                        for (int z=j; z<=j+2; ++z)
                        {
                            if (a[k][z] == 1) a[k][z] = 0;
                            else  a[k][z] = 1;
                        }
                }

        for (int i=0; i<n; ++i)
            for (int j=0; j<m; ++j)
                if (a[i][j] != b[i][j])
                {
                    System.out.println(-1);
                    return;
                }

        System.out.println(sum);
    }

}
