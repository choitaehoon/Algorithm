package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다시 풀기
@SuppressWarnings("Duplicates")
public class 톱니바퀴 {

    static List<Integer>[] list = new ArrayList[4];
    static Queue<Cogwheel> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<4; ++i) {
            String[] token = buffer.readLine().split("");
            list[i] = new ArrayList<>();
            for (int j=0; j<8; ++j)
                list[i].add(Integer.parseInt(token[j]));
        }

        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            queue.offer(new Cogwheel(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        turnWheel();
    }

    static void turnWheel(){
        boolean[] check = new boolean[4];

        while (!queue.isEmpty()) {
            Cogwheel cogwheel = queue.poll();

        }

    }
}

class Cogwheel {
    int wheel;
    int direction;

    public Cogwheel(int wheel, int direction) {
        this.wheel = wheel;
        this.direction = direction;
    }
}