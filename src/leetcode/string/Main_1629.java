package leetcode.string;

public class Main_1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] array = new int[26];
        array[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
        char[] keys = keysPressed.toCharArray();

        for (int i = 1; i < keys.length; ++i) {
            int index = keysPressed.charAt(i) - 'a';
            int minus = releaseTimes[i] - releaseTimes[i - 1];

            if (array[index] != 0) {
                if (array[index] < minus) {
                    array[index] = minus;
                }
            } else {
                array[index] = minus;
            }
        }

        int result = 0;
        int max = 0;
        int resultIndex = 0;
        for (int i = 25; i >= 0; --i) {
            if (max < array[i]) {
                max = array[i];
                resultIndex = i;
            }
        }

        return (char)(97 + resultIndex);
    }
}
