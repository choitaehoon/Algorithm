import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴다시 {

    static int[][] wheel = new int[4][8];
    static int[] multiple = {1,2,4,8};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //배열 삽입
        for (int i=0; i<4; ++i) {
            String[] store = buffer.readLine().split("");
            for (int j=0; j<8; ++j)
                wheel[i][j] = Integer.parseInt(store[j]);
        }

        //어떤 바퀴를 어느 방향으로 돌리는지
        int givenNumber = Integer.parseInt(buffer.readLine());
        for (int i=0; i<givenNumber; ++i){
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            int fixWheel = Integer.parseInt(token.nextToken());
            int direction = Integer.parseInt(token.nextToken());
            checkPole(fixWheel-1,direction);
        }

        int sum = 0;
        for (int i=0; i<4; ++i)
            sum += wheel[i][0] * multiple[i];
        System.out.println(sum);
    }

    //극을 체크 하는 메소드
    private static void checkPole(int fixWheel, int direction){
        left(fixWheel-1,-direction);
        right(fixWheel+1,-direction);
        rotateWheel(fixWheel,direction);
    }

    //왼쪽 회전 시키기
    private static void left(int fixWheel, int direction){
        if (fixWheel < 0)
            return;

        if (wheel[fixWheel][2] != wheel[fixWheel+1][6]) {
            left(fixWheel-1,-direction);
            rotateWheel(fixWheel,direction);
        }
    }

    //오른쪽 회전 시키기
    private static void right(int fixWheel, int direction){
        if (fixWheel > 3)
            return;

        if (wheel[fixWheel-1][2] != wheel[fixWheel][6]) {
            right(fixWheel+1, -direction);
            rotateWheel(fixWheel,direction);
        }
    }

    //회전 시킬 메소드
    private static void rotateWheel(int wheelNumber, int direction) {

        //시계 방향일 경우
        if (direction == 1){
            int temp =  wheel[wheelNumber][7];
            for (int i=7; i>0; --i)
                wheel[wheelNumber][i] = wheel[wheelNumber][i-1];
            wheel[wheelNumber][0] = temp;
        }

        //반시계 방향 일 경우
        else{
            int temp = wheel[wheelNumber][0];
            for (int i=0; i<7; ++i)
                wheel[wheelNumber][i] = wheel[wheelNumber][i+1];
            wheel[wheelNumber][7] = temp;
        }

    }

}
