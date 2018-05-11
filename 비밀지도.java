package practice;
import java.util.Scanner;

public class 비밀지도
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("입력 할 갯수는?");
        int num = input.nextInt();
        int[] arr1 = {input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt()};
        int[] arr2 = {input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt(),input.nextInt()};
        //출력 예상 결과 ["#####","# # #", "### #", "# ##", "#####"]

        for(int i=0 ; i<num; ++i)
        {
            int arr = arr1[i] | arr2[i];
            System.out.print(Integer.toBinaryString(arr)+" ");
        }
    }
}
