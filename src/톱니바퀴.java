import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 톱니바퀴 {

    static int[] oneWheel = new int[8];
    static int[] twoWheel = new int[8];
    static int[] threeWheel = new int[8];
    static int[] fourWheel = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<4; ++i)
            insertWheel(buffer.readLine());

        int givenNumber = Integer.parseInt(buffer.readLine());
        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

            int wheel = Integer.parseInt(tokenizer.nextToken());
            int direction = Integer.parseInt(tokenizer.nextToken());

            spinWheel(wheel, direction);
        }

    }

    //바퀴 배열에 삽입
    private static void insertWheel(String text){
        for (int i=0; i<4; ++i){
            String[] wheel = text.split("");
            for (int j=0; j<8; ++j) {
                if (i == 0)
                    oneWheel[j] = Integer.parseInt(wheel[j]);
                else if (i == 1)
                    twoWheel[j] = Integer.parseInt(wheel[j]);
                else if (i == 2)
                    threeWheel[j] = Integer.parseInt(wheel[j]);
                else
                    fourWheel[j] = Integer.parseInt(wheel[j]);
            }
        }
    }

    private static void spinWheel(int wheel, int direction) {

        //회전 체크 하기
        checkRotation(wheel,direction);
    }

    private static void checkRotation(int wheel, int direction) {
        //첫번 째일때
        if (wheel == 0 ){
            if (oneWheel[2] == twoWheel[6])
                return;
            rotation(oneWheel, twoWheel, direction);
            if (twoWheel[2] == threeWheel[6])
                return;
            rotation(twoWheel, threeWheel, -1 * direction);
            if (threeWheel[2] == fourWheel[6])
                return;
            rotation(threeWheel, fourWheel, -1 * direction);
        }
        //맨 마지막 일때
        else if (wheel == 3){

        }
        //1, 2 일때 -> 중간일 때
        else {

        }
    }

    private static void rotation(int[] arrayOne, int[] arrayTwo, int rotate) {
        //시계 회전
        if (rotate == 1){
            int temp = arrayTwo[7];
            for (int i=0; i<8; ++i)
                arrayTwo[i] = arrayTwo[i+1];
            arrayTwo[0] = temp;
        }
        //반시계 회전
        else if (rotate == -1){
            int temp = arrayOne[0];
            for (int i=7; i>=0; --i)
                arrayOne[i-1] = arrayOne[i];
            arrayOne[7] = temp;
        }
    }

}
