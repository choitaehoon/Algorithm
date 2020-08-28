package easy;

public class Main168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (26 < n) {
            int space = n % 26;

            if (space == 0) {
                result.append('Z');
                n /= 26;
                n--;
            } else {
                result.append((char)('A' + space - 1));
                n /= 26;
            }

        }
        result.append(n % 26 == 0 ? 'Z' : (char)('A' + n - 1));

        return result.reverse().toString();
    }

}