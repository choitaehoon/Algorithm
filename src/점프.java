import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프 {

    static int[][] course;
    static int givenNumber;
    static boolean[][] checkSearch;
    static long[][] numbers;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenNumber = Integer.parseInt(buffer.readLine());
        course = new int[givenNumber][givenNumber];
        checkSearch = new boolean[givenNumber][givenNumber];
        numbers = new long[givenNumber][givenNumber];

        for (int i=0; i<givenNumber; ++i) {
            StringTokenizer token = new StringTokenizer(buffer.readLine());
            for(int j=0; j<givenNumber; ++j)
                course[i][j] = Integer.parseInt(token.nextToken());
        }

        System.out.println(checkCourse(0,0));
    }

    private static int checkCourse(int x, int y) {

        //okay
        if (givenNumber-1 < x || givenNumber-1 < y)
            return 0;

        //okay
        if (x == givenNumber-1 && y == givenNumber-1) {
            return 1;
        }

        if (numbers[x][y] > 0)
            return (int)numbers[x][y];

        int ret = course[x][y];
        ret += checkCourse(x, y+course[x][y]);
        ret += checkCourse(x+course[x][y],  y);

        return ret;
    }
}