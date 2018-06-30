public class Z
{
    static int search(int n, int r, int c) // n: 배열의 크기 r: 가로 c: 세로
    {
        int[][] temp = new int[(int)Math.pow(2,n)][(int)Math.pow(2,n)]; //배열의 크기
        int quadrant = (temp.length/2) * (temp.length/2); //한 사분면이 갖고 있는 길이
        int sum = 0; // 더해서 반환할 변수
        if(temp.length/2 < r) //1,2사분면을 찾고 있으면
        {
            if(temp.length/2 < c) //1사분면에 존재 한다면
                sum = search(r,c);
        }
        else //3,4분면을 찾고 있으면
        {

        }
        return 0;
    }

    static int search(int r, int c)
    {
        int temp = 0; //이동한 거리를 계산해서 리턴하는 변수
        if(r % 2 == 0) //오른쪽으로 가야하면
            return search()
    }

    public static void main(String[] args)
    {
        System.out.println(search(3,7,7));
    }
}
