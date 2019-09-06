package 다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 만취한상범 {

    private static int givenNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());

        for (int i=0; i<givenNumber; ++i)
            System.out.println(openCloseDoor(Integer.parseInt(buffer.readLine())));
    }

    private static int openCloseDoor(int round) {
        boolean[] doors = new boolean[round+1];

        for (int i=2; i<=round; ++i)
            for (int j=i; j<=round; j+=i)
                doors[j] = !doors[j];

        return countDoors(round, doors);
    }

    private static int countDoors(int round, boolean ... doors) {
        int count = 0;
        for (int i=1; i<=round; ++i)
            if (!doors[i])
                ++count;

        return count;
    }

}
