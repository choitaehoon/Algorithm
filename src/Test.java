public class Test {
    public static void main(String[] args) {
//        int[] T = {5, 6};
//        int[] T = {5, -2, 3, 8, 6};

//        int[] T = {-5, -5, -5, -42, 6, 12};
        int[] T = {-3, 6, -5, 3, 2, 7};
        System.out.println(solution(T));
    }

    public static int solution(int[] T) {
        int start = 0;
        int end = T.length-1;

        if (T.length == 2)
            return 1;

        while (end-start != 1) {
            if (T[start] < T[end])
                end -= 1;

            else if (T[start] > T[end])
                start += 1;

            else
                end -= 1;
        }

        return end+1;
    }
}
