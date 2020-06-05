package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 만취한상범 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        //방 개방 : False , 방 close : true
        for (int i = 0; i < givenNumber; ++i) {
            int room = Integer.parseInt(buffer.readLine());
            boolean[] roomArray = new boolean[room + 1];
            int nowRound = 2;
            int plusRound = 0;

            for (int j = 0; j < room - 1; ++j) {
                int nowRoom = nowRound + plusRound;

                while (nowRoom <= room) {
                    if (roomArray[nowRoom])
                        roomArray[nowRoom] = false;
                    else
                        roomArray[nowRoom] = true;
                    nowRoom += nowRound;
                }

                ++nowRound;
                plusRound = 0;
            }

            int count = 0;
            for (int j = 1; j <= room; ++j) {
                if (!roomArray[j])
                    ++count;
            }

            System.out.println(count);
        }

    }

}
