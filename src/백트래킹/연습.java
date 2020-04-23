package 백트래킹;

public class 연습 {

    static int[] array = {1,2,3,4,5};
    static boolean[] isCheck = new boolean[5];

    public static void main(String[] args) {
        recursive(0, 3, 5, 0, "");
    }

    private static void recursive(int index, int limit, int total, int count, String temp) {
        if (limit == count) {
            System.out.println(temp);
            return;
        }

        if (index >= total) {
            return;
        }

        recursive(index + 1, limit, total, count + 1, temp+array[index]);
        recursive(index + 1, limit, total, count, temp);
    }

}
