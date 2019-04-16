import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세수 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int[] array = new int[3];

        for (int i=0; i<3; ++i)
            array[i] = Integer.parseInt(token.nextToken());

        Arrays.sort(array);
        System.out.println(array[1]);
    }
}
