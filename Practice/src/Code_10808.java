import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Code_10808
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> map = new HashMap<>();

        for(int i=97; i<123; ++i)
            map.put((char)i,0);
        String temp = buffer.readLine();

        for (int i=0; i<temp.length(); ++i)
            map.put(temp.charAt(i), map.get(temp.charAt(i))+1);

        for(Map.Entry<Character,Integer> entry : map.entrySet())
            System.out.printf("%d ",entry.getValue());
    }
}
