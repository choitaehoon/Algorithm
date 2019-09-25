import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 퇴사 {

    static int givenNumber;
    static int[][] array ;
    static boolean[] check;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[2][givenNumber];
        check = new boolean[givenNumber];

        //배열 삽입
        for (int i=0; i<givenNumber; ++i)
            insertArray(i, buffer.readLine());

        //최대 수익 구하기
        getMaxPrice(0,0);

        System.out.println(max);
    }

    //최대 수익
    private static void getMaxPrice(int index, int sum) {

        if (index >= givenNumber)
            return;

        if (array[0][index] + index < givenNumber)
            max = Math.max(max,sum);

        for (int i=index; i<givenNumber; ++i)
            if (!check[i]){
                check[i] = true;
                getMaxPrice(index+array[0][i], sum+array[1][i]);
                check[i] = false;
            }
    }

    //배열 삽입
    private static void insertArray(int index, String readLine) {
        StringTokenizer token = new StringTokenizer(readLine);
        array[0][index] = Integer.parseInt(token.nextToken());
        array[1][index] = Integer.parseInt(token.nextToken());
    }

}
