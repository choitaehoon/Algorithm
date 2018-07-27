import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_10824
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());

        String temp1 = tokenizer.nextToken()+tokenizer.nextToken();
        String temp2 = tokenizer.nextToken()+tokenizer.nextToken();
        System.out.println(Long.parseLong(temp1)+Long.parseLong(temp2));
    }
}
