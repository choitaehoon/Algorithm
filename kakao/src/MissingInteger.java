import java.util.Arrays;

public class MissingInteger {
    public static int search(int... A) {
        boolean[] checker = new boolean[A.length + 1]; //배열 1부터 사용하기에 +1

        for(int i = 0 ; i < A.length ; i++){
            int value = A[i];
            System.out.println(value);
            if(value > 0 && value < checker.length){ //value가 음수이거나 value가 checker길이보다 크면 건너띄는 조건
                checker[value] = true;
            }
        }
        System.out.println(Arrays.toString(checker));
        for(int i = 1 ; i < checker.length ; i++){
            if(checker[i] == false){
                return i;
            }
        }

        return checker.length;
    }

    public static void main(String[] args) {
        int[] a = {88, 75, 1, 5};
        System.out.println(search(a));
    }
}
