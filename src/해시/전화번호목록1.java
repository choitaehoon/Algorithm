package 해시;

import java.util.Arrays;

public class 전화번호목록1 {

    public static void main(String[] args) {
        //        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};
//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"113", "12340", "123440", "12345", "98346"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i <phone_book.length - 1; ++i) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }
}
