import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지 {

    static int givenNumer;
    static int[] abc = new int[3];
    static int[] array = {300,60,10};
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumer = Integer.parseInt(buffer.readLine());

        calculate();
        if (sum == givenNumer)
            System.out.println(abc[0]+" "+abc[1]+" "+abc[2]);
        else
            System.out.println(-1);
    }

    private static void calculate() {

        for (int i=0; i<3; ++i){
            int count = 0;
            while (sum + array[i] <= givenNumer) {
                sum += array[i];
                count++;
            }
            abc[i] = count;
        }
    }

}
