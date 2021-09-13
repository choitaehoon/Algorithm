package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[][] array = new int[n + 1][n + 1];
        solution(array, n);
    }

    private static void solution(int[][] array, int n) {
        arrayStore(array);
        array[1][0] = 0;
        Queue<Emozi> queue = new LinkedList<>();
        queue.offer(new Emozi(1, 0));

        search(queue, array, n);
        result(array, n);
    }

    private static void arrayStore(int[][] array) {
        for (int i = 0; i < array.length; ++i) {
            Arrays.fill(array[i], -1);
        }
    }

    private static void search(Queue<Emozi> queue, int[][] array, int n) {
        while (!queue.isEmpty()) {
            Emozi emozi = queue.poll();

            int emoticon = emozi.emoticon;
            int clipBoard = emozi.clip;

            if (array[emoticon][emoticon] == - 1) {
                array[emoticon][emoticon] = array[emoticon][clipBoard] + 1;
                queue.offer(new Emozi(emoticon, emoticon));
            }

            if (emoticon + clipBoard <= n && array[emoticon + clipBoard][clipBoard] == - 1) {
                array[emoticon + clipBoard][clipBoard] = array[emoticon][clipBoard] + 1;
                queue.offer(new Emozi(emoticon + clipBoard, clipBoard));
            }

            if (emoticon - 1 >= 0 && array[emoticon - 1][clipBoard] == -1) {
                array[emoticon - 1][clipBoard] = array[emoticon][clipBoard] + 1;
                queue.offer(new Emozi(emoticon - 1, clipBoard));
            }
        }

    }

    private static void result(int[][] array, int n) {
        int check = -1;
        for (int i = 0; i <= n; ++i) {
            if (array[n][i] != -1 && (check == -1 || check > array[n][i]))
                check = array[n][i];
        }

        System.out.println(check);
    }

    //2126753390


}

class Emozi {

    int emoticon;
    int clip;

    public Emozi(int emoticon, int clip) {
        this.emoticon = emoticon;
        this.clip = clip;
    }

}
