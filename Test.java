import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println(map.get(2) == null? "ㄴㄴ": 1);
    }
}