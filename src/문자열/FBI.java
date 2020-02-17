package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FBI {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        inputEnter();
        printFBI();
    }

    private static void inputEnter() throws IOException {
        BufferedReader buffer =
                new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; ++i) {
            String temp = buffer.readLine();
            if (temp.contains("FBI"))
                list.add(i+1);
        }
    }

    private static void printFBI() {
        if (list.size() == 0)
            System.out.println("HE GOT AWAY!");
        else {
            for (Integer integer : list)
                System.out.print(integer+" ");
        }
    }

}
