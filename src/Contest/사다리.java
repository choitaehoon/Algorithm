package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 사다리 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        double x,y,c;

        StringTokenizer token = new StringTokenizer(buffer.readLine());
        x = Double.parseDouble(token.nextToken());
        y = Double.parseDouble(token.nextToken());
        c = Double.parseDouble(token.nextToken());

        double left = 0;
        double right = Math.min(x,y);

        for (int i=0; i<10000; ++i) {

            double middle = (left+right) / 2.0;
            double h1 = Math.sqrt(x*x-middle*middle);
            double h2 = Math.sqrt(y*y-middle*middle);
            double h = (h1*h2)/(h1+h2);

            if (h < c)
                right = middle;
            else
                left = middle;

        }

        System.out.printf("%.3f",left);

    }

}
