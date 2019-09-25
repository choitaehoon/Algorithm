import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 연산자끼워넣기 {

    static int givenNumber;
    static int[] array;
    static int min = Integer.MAX_VALUE;
    static int max = min * -1;
    static int[] operator = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber];

        //배열에 삽입
        insertArray(buffer.readLine());

        //연산자 삽입
        insertOperator(buffer.readLine());

        //재귀 이용하여 최대 최소 구하기
        getMaxAndMin(0,array[0]);

        System.out.println(max);
        System.out.println(min);
    }

    //재귀 이용하여 최대 최소 구하기
    private static void getMaxAndMin(int numberIndex ,int sum) {
        if (numberIndex == givenNumber-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i=0; i<4 ; ++i){
            if (operator[i] > 0){
                operator[i]--;
                if (i == 0)
                    getMaxAndMin(numberIndex+1, sum+array[numberIndex+1]);
                else if (i == 1)
                    getMaxAndMin(numberIndex+1, sum-array[numberIndex+1]);
                else if (i == 2)
                    getMaxAndMin(numberIndex+1, sum*array[numberIndex+1]);
                else
                    getMaxAndMin(numberIndex+1, sum/array[numberIndex+1]);
                operator[i]++;
            }
        }

    }

    //연산자 삽입
    private static void insertOperator(String readLine) {
        StringTokenizer token = new StringTokenizer(readLine);
        for (int i=0; i<4; ++i)
            operator[i] = Integer.parseInt(token.nextToken());
    }

    //배열 삽입
    private static void insertArray(String readLine) {
        StringTokenizer token = new StringTokenizer(readLine);
        for (int i=0; i<givenNumber; ++i)
            array[i] = Integer.parseInt(token.nextToken());
    }

}