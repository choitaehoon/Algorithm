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
                sum = search(0,0,r,c,temp.length);
        }
        else //3,4분면을 찾고 있으면
        {

        }
        return sum;
    }

    static int search(int s, int e, int r, int c, int length) // s,e시작    r, c는 주어진 숫자
    {
        //종료 조건
        if(s == r && e == c)
            return 0;
        else if((r % 2 == 0 && r % 2 == 1) && c % 2 ==0) //오른쪽으로 가야하면
            return search(s,e,r,c+1,length)+1;
        else if(c % 2 == 1 && r % 2 == 0) //왼쪽아래 대각선으로 가야하면
            return search(s,e,r+1,c-1,length)+1;// 대각선 이동
        else if(length % 2 == 0) //z 다 그리고서 이동해야 될 때
            return search()
    }

    public static void main(String[] args)
    {
        System.out.println(search(3,7,7));
    }
}
