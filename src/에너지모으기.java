import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 에너지모으기 {

    static int givenNumer;
    static int[] array;
    static int max;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumer = Integer.parseInt(buffer.readLine());
        array = new int[givenNumer];
        check = new boolean[givenNumer];

        //배열 삽입
        insertArray(buffer.readLine());

        //최대 에너지양 구하기
        System.out.println(getMaxEnergy());
    }

    //최대 에너지양 구하기
    private static int getMaxEnergy() {

        int ret = 0;
        for (int i=1; i<givenNumer-1; ++i){
            if (check[i]) continue;

            int left = i - 1;
            int right = i + 1;

            while (check[left]) --left;
            while (check[right]) ++ right;

            check[i] = true;
            ret = Math.max(ret,getMaxEnergy() + (array[left] * array[right]));
            check[i] = false;
        }
        return ret;
    }

    //배열 삽입
    private static void insertArray(String text) {
        StringTokenizer token = new StringTokenizer(text);
        for (int i=0; i<givenNumer; ++i)
            array[i] = Integer.parseInt(token.nextToken());
    }

}
