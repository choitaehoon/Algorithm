package 해시;

public class 전화번호목록다시풀기 {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        String comparison = phone_book[0];

        for (int i=1; i<phone_book.length; ++i) {
            String temp = phone_book[i];
            if (temp.length() < comparison.length())
                continue;

            for (int j=0; j<temp.length(); ++j) {
                if (temp.length()-j < comparison.length())
                    break;

                if (temp.substring(j,comparison.length()+j).equals(comparison))
                    return false;
            }
        }

        return true;
    }
}
