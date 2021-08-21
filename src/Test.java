import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            int index = Integer.parseInt(buffer.readLine());
            array[i] = index;
        }


        List<Integer> store = new ArrayList<>();
        int i = 1;

        while (store.size() != 1000) {

            String check = String.valueOf(i);
            if (!(i % 3 == 0 || check.charAt(check.length() - 1) == '3')) {
                store.add(i);
            }

            ++i;
        }

        for (int k = 0; k < n; ++k) {
            System.out.println(store.get(array[k] - 1));
        }

    }

}
