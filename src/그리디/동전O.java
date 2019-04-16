package 그리디;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

@SuppressWarnings("Duplicates")
public class 동전O {

    static List<Integer> array;
    static int k;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        int n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        array = new ArrayList<>();

        for (int i=0; i<n; ++i)
            array.add(Integer.parseInt(buffer.readLine()));

        Collections.sort(array);
        Collections.reverse(array);

        System.out.println(recursive(0,0));
    }

    public static int recursive(int index, int sum) {
        if (index > array.size()-1)
            return 0;

        else {
            while (index <= array.size()-1 && sum + array.get(index) <= k) {
                ++count;
                sum += array.get(index);
            }
            recursive(index+1, sum);
        }
        return count;
    }
}
