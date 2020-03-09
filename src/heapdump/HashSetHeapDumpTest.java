package heapdump;

import java.util.HashSet;
import java.util.Set;

public class HashSetHeapDumpTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<3000000; ++i) {
            set.add(i);
        }

        System.out.println(set);

    }

}
