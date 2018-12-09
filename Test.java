import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(7);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        Iterator iterator;
    }
}