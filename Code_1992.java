import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_1992
{
    /*
     * 압축 시도할때 안나눠지면 (부터 시작, 그 구역이 압축 다되면 )로 끝낸다.
     * 압축을 시도 하지 못할때마다 구역을 1/2로 나눈다.
     */
    static int [][] array;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        array = new int[number][number];

        for (int i=0; i<number; ++i)
        {
            String[] temp = buffer.readLine().split("");
            for (int j=0; j<number; ++j)
                array[i][j] = Integer.parseInt(temp[j]);
        }

        search(0,0,number);
        System.out.println(builder);
    }

    public static boolean solve(int x, int y, int size)
    {
        int test = array[x][y];
        for (int i=x; i<x+size; ++i)
            for (int j=y; j<y+size; ++j)
                if (test != array[i][j])
                {
                    builder.append("(");
                    return false;
                }
        builder.append(test);
        return true;
    }

    public static void search(int x, int y, int size)
    {
        if (solve(x,y,size))
            return;

        for (int i=0; i<2; ++i)
            for (int j=0; j<2; ++j)
                search(x+i*(size/2),y+j*(size/2),size/2);
        builder.append(")");
    }

}
