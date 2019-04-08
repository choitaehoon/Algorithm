package 해시;

public class 전화번호목록다시풀기 {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"113", "12340", "123440", "12345", "98346"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        for (int i=0; i<phone_book.length; ++i) {
            String comparison = phone_book[i];
            int count = 0;

            for (String temp : phone_book)
                if (temp.startsWith(comparison))
                    ++count;

            if (1 < count)
                return false;
        }

        return true;
    }



}
