public class PermCheck
{
    public static int check(int A[])
    {
        int[] counter = new int [A.length];
        for(int i= 0; i< A.length; i++){
            if (A[i] < 1 || A[i] > A.length)
                return 0;
            else if(counter[A[i]-1] == 1)
                return 0;
            else
                counter[A[i]-1] = 1;
        }
        return 1;
    }

    public static void main(String[] args)
    {
        int[] temp ={9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        System.out.println(check(temp));
    }
}
