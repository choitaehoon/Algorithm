package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방학숙제 {

    static int vacation;
    static int math;
    static int language;
    static int mathOneMax;
    static int languageOneMax;

    public static void main(String[] args) throws IOException {
        inputVacation();
        playMax();
    }

    private static void inputVacation() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        vacation = Integer.parseInt(buffer.readLine());
        language = Integer.parseInt(buffer.readLine());
        math = Integer.parseInt(buffer.readLine());
        languageOneMax = Integer.parseInt(buffer.readLine());
        mathOneMax = Integer.parseInt(buffer.readLine());
    }

    private static void playMax() {
        int mathDay = math % mathOneMax == 0 ?
                math / mathOneMax : math / mathOneMax + 1;
        int languageDay = language % languageOneMax == 0 ?
                language / languageOneMax : language / languageOneMax + 1;
        int day = Math.max(mathDay, languageDay);

        System.out.println(vacation - day);
    }

}
