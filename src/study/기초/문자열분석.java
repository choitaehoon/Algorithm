package study.기초;

import java.util.Scanner;

public class 문자열분석 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        while (input.hasNextLine()) {

            int smallLetter = 0;
            int upperCase = 0;
            int number = 0;
            int gap = 0;

            String keword = input.nextLine();

            for (char data : keword.toCharArray()) {
                if (97 <= data &&  data <= 122)
                    smallLetter++;
                else if (65 <= data && data <= 90)
                    ++upperCase;
                else if (32 == data)
                    ++gap;
                else
                    ++number;
            }
            System.out.printf("%d %d %d %d\n",smallLetter,upperCase,number,gap);
        }

    }
}
