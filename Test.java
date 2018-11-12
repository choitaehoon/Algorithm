import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = buffer.readLine().split(" ");
        int change = 0;
        String calculator = temp[0]; if (temp.length == 2) change = Integer.parseInt(temp[1]);
        System.out.println(temp.length+" "+change);
    }
}