package 프로그래머스;

import java.math.BigInteger;

public class 큰수만들기 {

    static BigInteger sum = new BigInteger("0");
    static char[] array;
    static int limit;

    public static void main(String[] args) {
        System.out.println(solution("1924",2));
        System.out.println(solution("1231234",3));
//        System.out.println(solution("4177252841654984651321654984651321987981321354",4));
    }

    public static String solution(String number, int k) {
        array = number.toCharArray();
        limit = k;
        recursive(0,"",0);
        return new BigInteger(String.valueOf(sum)).toString();
    }

    private static void recursive(int index, String store, int count) {
        if (count == array.length - limit) {
            BigInteger bigInteger = new BigInteger(store);
            if (bigInteger.compareTo(sum) > 0)
                sum = bigInteger;
            return;
        }

        if (index == array.length)
            return;

        recursive(index+1,store+array[index],count+1);
        recursive(index+1,store,count);
    }

}
