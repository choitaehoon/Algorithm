package sw.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[1000001];

        for (int i=2; (i+i)<=1000000; ++i) {
            if (!check[i])
                for (int j=(i+i); j<=1000000; j+=i)
                    check[j] = true;
        }

        do {
            int number = Integer.parseInt(buffer.readLine());
            if (number == 0) return;
            boolean search = false;

            for (int i=3; i<number; ++i) {
                int temp = number - i;
                    if (i+temp == number && !check[i] && !check[temp] ) {
                        search = true;
                        System.out.printf("%d = %d + %d\n", number, i, temp);
                        break;
                    }

            }

            if (!search)
                System.out.println("Goldbach's conjecture is wrong.");

        }while (true);

    }
}
