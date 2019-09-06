package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class 공유기설치 {

    private static int[] coordinate;
    private static int house;
    private static int share;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(buffer.readLine());

        house = Integer.parseInt(token1.nextToken());
        share = Integer.parseInt(token1.nextToken());
        coordinate = new int[house];

        for (int i=0; i<house; ++i)
            coordinate[i] = Integer.parseInt(buffer.readLine());

        Arrays.parallelSort(coordinate);

        System.out.println(distanceBetweenRouter());
    }


    private static int distanceBetweenRouter() {
        int left = 1; //가장 짧은 거리
        int right = coordinate[house-1] - coordinate[0]; //가장 긴 거리
        int answer = 0;

        while (left <= right){

            int street;
            int middle = (left + right)/2;
            int s = coordinate[0];
            int countShare = 1;

            for (int i=1; i<house; ++i){
                street = coordinate[i] - s;
                if (middle <= street){
                    countShare++;
                    s = coordinate[i];
                }
            }

            if (countShare >= share){
                answer = middle;
                left = middle +1;
            }
            else {
                right = middle - 1;
            }

        }
        return answer;
    }

}
