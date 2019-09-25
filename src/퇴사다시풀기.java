import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사다시풀기 {

    static int givenNumber;
    static int[][] resign;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        resign = new int[2][givenNumber+1];
        dp = new int[givenNumber+1];

        //배열 삽입
        for (int i=0; i<givenNumber; ++i)
            insertArray(i, buffer.readLine());

        //최대 이익 구하기
        getMaxProfit();

        System.out.println(dp[0]);
    }

    //최대 이익
    private static void getMaxProfit() {
        for (int i=givenNumber-1; i>=0; --i){
            int next = resign[0][i] + i;

            if (next > givenNumber)
                dp[i] = dp[i+1];
            else
                dp[i] = Math.max(dp[i+1], resign[1][i] + dp[next]);

        }

    }

    //배열 삽입
    private static void insertArray(int index, String readLine) {
        StringTokenizer token = new StringTokenizer(readLine);
        resign[0][index] = Integer.parseInt(token.nextToken());
        resign[1][index] = Integer.parseInt(token.nextToken());
    }

}
