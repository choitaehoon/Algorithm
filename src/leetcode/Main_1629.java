package leetcode;

public class Main_1629 {

    public static void main(String[] args) {
        System.out.println(
                slowestKey(
                        new int[]{12,23,36,46,62}, "spuda"
                )
        );
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int size = releaseTimes.length;
        int maxNum = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);

        for (int i = 1; i < size; ++i) {
            int nowReleaseTime = releaseTimes[i] - releaseTimes[i - 1];
            char nowKeyPress = keysPressed.charAt(i);

            if ((maxNum == nowReleaseTime && (int)maxChar < (int)nowKeyPress) ||
                maxNum < nowReleaseTime) {
                maxChar = nowKeyPress;
                maxNum = nowReleaseTime;
            }

        }

        return maxChar;
    }

}