package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자박스 {

    static int [][][] currentArray = new int[401][401][401];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());
        List<Integer> upNumber = new ArrayList<>();
        List<Integer> downNumber = new ArrayList<>();

        upNumber.add(0);
        downNumber.add(0);

        StringTokenizer upToken = new StringTokenizer(buffer.readLine());
        StringTokenizer downToken = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            int insertNumber = Integer.parseInt(upToken.nextToken());
            if (insertNumber != 0)
                upNumber.add(insertNumber);
        }

        for (int i=0; i<givenNumber; ++i) {
            int insertNumber = Integer.parseInt(downToken.nextToken());
            if (insertNumber != 0)
                downNumber.add(insertNumber);
        }

        for (int k=1; k<=givenNumber; ++k) {
            for (int i=1; i<upNumber.size(); ++i) {
                for (int j=1; j<downNumber.size(); ++j) {

                    if ( i > k ) continue;
                    if ( j > k ) continue;

                    int currentSum = currentArray[k-1][i-1][j-1] + upNumber.get(i) * downNumber.get(j);

                    if (j-1 >= 0 && k-1 >= i)
                        currentSum = Math.max(currentSum, currentArray[k-1][i][j-1]);
                    if (i-1 >=0 && k-1 >= j)
                        currentSum = Math.max(currentSum, currentArray[k-1][i-1][j]);

                    currentArray[k][i][j] = currentSum;
                }
            }
        }

        System.out.println(currentArray[givenNumber][upNumber.size()-1][downNumber.size()-1]);
    }
}
