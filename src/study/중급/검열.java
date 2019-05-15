package study.중급;

import java.io.*;

@SuppressWarnings("Duplicates")
public class 검열 {

    static char[] compare;
    static char[] keword;
    static char[] leftStore;
    static char[] rightStore;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        compare = buffer.readLine().toCharArray();
        keword = buffer.readLine().toCharArray();
        leftStore = new char[300001];
        rightStore = new char[300001];

        int compareLength = compare.length;
        int start = 0;
        int end = keword.length-1;
        boolean isLeft = true;
        int leftPos = 0;
        int rightPost = 0;

        while (start <= end) {
            //왼쪽 일때
            if (isLeft) {
                for (; start<=end; ++start) {
                    leftStore[leftPos++] = keword[start];
                    if (leftPos - compareLength >= 0 && isLeftMatch(leftPos - compareLength, compareLength)) {
                        leftPos -= compareLength;
                        isLeft = false;
                        start++;
                        break;
                    }
                }
            }

            //오른쪽일때
            else {
                for (; end >= start; --end) {
                    rightStore[rightPost++] = keword[end];
                    if (rightPost - compareLength >= 0 && isRightMatch(rightPost - compareLength, compareLength)) {
                        rightPost -= compareLength;
                        isLeft = true;
                        end--;
                        break;
                    }
                }
            }

        }

        for (int i=0; i<leftPos; ++i)
            writer.write(leftStore[i]);

        for (int i=0; i<rightPost; ++i)
            writer.write(rightStore[i]);
        writer.close();
    }

    static boolean isLeftMatch(int start, int compareLength) {
        int compareIndex = 0;
        for (int i=start; i<start+compareLength; ++i)
            if (leftStore[i] != compare[compareIndex++])
                return false;

        return true;
    }

    static boolean isRightMatch(int start, int compareLength) {
        int compareIndex = 0;
        for (int i=start; i<start+compareLength; ++i)
            if (rightStore[i] != compare[compareIndex++])
                return false;

            return true;
    }
}
