public class Matrix2
{
    static int[][] temp = {
            {6,7,12,5},
            {5,3,11,18},
            {7,17,3,3},
            {8,10,14,9}
    };

    public static int min(int r,int c)
    {
        int a = 0;
        if (r == 0 && c ==0) return temp[r][c];
        else if(r == 0) a = min(r,c-1);
        else if(c == 0) a = min(r-1,c);
        else
            a = Math.min(min(r,c-1),min(r-1,c));
        return a+temp[r][c];
    }

    public static void main(String[] args) {
        System.out.println(min(3,3));
    }
}
