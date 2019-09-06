import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이 {

    static int[] array = new int[9];
    static List<Integer> seven = new ArrayList<>();
    static boolean[] check = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; ++i)
            array[i] = Integer.parseInt(buffer.readLine());

        findKey(0,0,0);

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<7; ++i)
            result.add(seven.get(i));
        Collections.sort(result);

        for (int i=0; i<7; ++i)
            System.out.println(result.get(i));
    }

    private static void findKey(int number, int sum, int person){
        if (sum == 100 && person == 7){
                for (int i=0; i<9; ++i) {
                    if (check[i])
                        seven.add(array[i]);
                }
                return;
        }

        for (int i=0; i<9; ++i){
            if (!check[i] && person < 8){
                check[i] = true;
                findKey(number+1, sum+array[i],person+1);
                check[i] = false;
            }
        }
    }

}
