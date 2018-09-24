import java.util.Arrays;

public class MaxThree
{
    public static int solution(int[] A)
    {
        Arrays.sort(A);
        int temp1=0,temp2 =0;//비교 변수

        if(A[A.length-1] <0) //0보다 작을때
            return A[A.length-1] * A[A.length-2] * A[A.length-3];
        if(A[A.length-2] <0 || A[A.length-3] <0) //음수일때 처리하기
            return A[0] * A[1] * A[A.length-1];

        temp1 = A[A.length-1] * A[A.length-2] * A[A.length-3];
        temp2 =A[0] * A[1] * A[A.length-1];
        return temp1 < temp2 ? temp2 : temp1;
    }

    public static void main(String[] args)
    {
        int[] a ={-3,1,2,-2,5,6};
        System.out.println(solution(a));
    }
}
