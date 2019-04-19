package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int givenNumber;
    static int[] givenArray;
    static int[] givenCalculation;
    static int min = Integer.MAX_VALUE;
    static int max = min * -1;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        givenArray = new int[givenNumber];

        StringTokenizer token = new StringTokenizer(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            givenArray[i] = Integer.parseInt(token.nextToken());

        StringTokenizer tokenCalculate = new StringTokenizer(buffer.readLine());
        givenCalculation = new int[tokenCalculate.countTokens()];

        for (int i=0; i<givenCalculation.length; ++i)
            givenCalculation[i] = Integer.parseInt(tokenCalculate.nextToken());

        findMaximumMinimum(0, givenArray[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void findMaximumMinimum (int index, int sum) {
        if (index == givenNumber -1) {
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }

        else  {
            for (int i=0; i<4; ++i) {
                if (givenCalculation[i] != 0) {
                    givenCalculation[i]--;

                    if (i == 0)
                        findMaximumMinimum(index+1, sum + givenArray[index+1]);
                    else if (i == 1)
                        findMaximumMinimum(index+1, sum - givenArray[index+1]);
                    else if (i == 2)
                        findMaximumMinimum(index+1, sum * givenArray[index+1]);
                    else
                        findMaximumMinimum(index+1, sum / givenArray[index+1]);

                    givenCalculation[i]++;
                }
            }
        }

    }
}
