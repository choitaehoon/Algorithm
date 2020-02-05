package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {

    static int givenNumber;
    static Queue<Screen> queue = new LinkedList<>();
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        array = new int[givenNumber+1][givenNumber+1];

        inputArrayAndQueue();
        checkEmoticonAndClip();
        System.out.println(resultEmoticon());
    }

    private static void inputArrayAndQueue() {
        for (int i = 0; i <= givenNumber; ++i) {
            Arrays.fill(array[i], -1);
        }

        array[1][0] = 0;
        queue.offer(new Screen(1,0));
    }

    private static void checkEmoticonAndClip() {
        while (!queue.isEmpty()) {
            Screen screen = queue.poll();
            int emoticon = screen.emoticon;
            int clip = screen.clip;

            calculateArray(emoticon, clip);
        }
    }

    private static void calculateArray(int emoticon, int clip) {
        if (array[emoticon][emoticon] == -1) {
            array[emoticon][emoticon] = array[emoticon][clip] + 1;
            queue.offer(new Screen(emoticon, emoticon));
        }
        if (emoticon + clip <= givenNumber && array[emoticon+clip][clip] == -1) {
            array[emoticon+clip][clip] = array[emoticon][clip] + 1;
            queue.offer(new Screen(emoticon+clip, clip));
        }
        if (emoticon - 1 >= 0 && array[emoticon-1][clip] == -1) {
            array[emoticon-1][clip] = array[emoticon][clip] + 1;
            queue.offer(new Screen(emoticon-1, clip));
        }
    }

    private static int resultEmoticon() {
        int result = -1;

        for (int i=0; i<=givenNumber; ++i) {
            if (array[givenNumber][i] != -1 && (result == -1 || result > array[givenNumber][i]))
                result = array[givenNumber][i];
        }

        return result;
    }

}

class Screen {
    int emoticon;
    int clip;

    public Screen(int emoticon, int clip) {
        this.emoticon = emoticon;
        this.clip = clip;
    }
}