package kakao;

public class n진수게임 {

    static char[] array = new char[16];

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        inputArray();
        String temp = changeWord(n, t, m);

        return printGo(t, m, p, temp);
    }

    private static String printGo(int t, int m, int p, String temp) {
        StringBuilder result = new StringBuilder();

        p -= 1;
        for (int sum = 0; sum < t; ++sum, p += m) {
            result.append(temp.charAt(p));
        }

        return result.toString();
    }

    private static void inputArray() {
        for (int i=0; i<16; ++i) {
            if (i < 10)
                array[i] = (char)(48 + i);
            else
                array[i] = (char)(55 + i);
        }
    }

    private static String changeWord(int n, int t, int m) {
        String temp = "";

        for (int i=0; i<t*m; ++i) {
            temp += changeWord(n, i);
        }

        return temp;
    }

    private static String changeWord(int n, int index) {
        StringBuilder store = new StringBuilder();

        while (index / n != 0) {
            int x = index % n;
            store.append(x);

            index /= n;
        }

        store.append(array[index % n]);
        return store.reverse().toString();
    }

}