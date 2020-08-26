package easy;

public class Main914 {

    public static void main(String[] args) {
//        System.out.println(hasGroupsSizeX(
//                new int[]{1,2,3,4,4,3,2,1}
//        ));
        System.out.println(hasGroupsSizeX(
                new int[]{1,1,1,2,2,2,3,3}
        ));
//        System.out.println(hasGroupsSizeX(
//                new int[]{1}
//        ));
//        System.out.println(hasGroupsSizeX(
//                new int[]{1,1}
//        ));
//        System.out.println(hasGroupsSizeX(
//                new int[]{1,1,2,2,2,2}
//        ));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] result = new int[10_000];
        for (int deckValue : deck)
            result[deckValue]++;

        int g = -1;
        for (int i = 0; i < 10_000; ++i) {
            if (result[i] > 0) {
                if (g == -1) {
                    g = result[i];
                } else {
                    g = gcd(g, result[i]);
                }
            }
        }

        return g >= 2;
    }

    private static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}