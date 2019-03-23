package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_2022
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        double x, y ,c =0;

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        x = Double.parseDouble(tokenizer.nextToken()); y = Double.parseDouble(tokenizer.nextToken());
        c = Double.parseDouble(tokenizer.nextToken());

        double left = 0; double right = Math.min(x,y); //왜 right를 작게 만들까?
        for (int i=0; i<10000; ++i)
        {
            double middle = (left+right) / 2.0;
            double h1 = Math.sqrt((x*x)-(middle*middle));
            double h2 = Math.sqrt((y*y)-(middle*middle));
            double h = (h1*h2)/(h1+h2);
            if (h < c)
                right = middle;
            else
                left = middle;
        }
        System.out.printf("%.3f",left);
    }
}
