package easy;

public class Main605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(
                new int[]{0, 0, 1, 0, 0}, 1
        ));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedLen = flowerbed.length;

        if (flowerbedLen == 1 && n == 1 && flowerbed[0] == 1) {
            return false;
        } else if (flowerbedLen == 1 && n == 1 && flowerbed[0] == 0) {
            return true;
        } else if (flowerbedLen == 1 && n == 0 && flowerbed[0] == 1) {
            return true;
        } else if (flowerbedLen == 1 && n == 0 && flowerbed[0] == 0) {
            return true;
        }

        for (int i = 0; i < flowerbedLen; ++i) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbedLen - 1) {
                    if (flowerbed[i - 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }
        }

        return n <= 0;
    }

}
