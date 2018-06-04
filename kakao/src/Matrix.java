public class Matrix {
    static int[][] a = {{6, 7, 12, 5}, {5, 3, 11, 18}, {7, 17, 3, 3}, {8, 10, 14, 9}};
    

    static int 점수(int r, int c) {
        System.out.printf("점수(%d,%d)",r,c);
        if (r == 0 && c == 0) return a[0][0];
        int temp = 0; //이전단계 숫자
        if (r > 0 && c > 0) //왼쪽과 위가 있을때
            temp = Math.min(점수(r - 1, c), 점수(r, c - 1));
        else if (r == 0) //왼쪽이 없을 때
            temp = 점수(r, c - 1);
        else //위가 없을때
            temp = 점수(r-1,c);
        return temp+a[r][c];
    }

    public static void main(String[] args) {
        System.out.println(점수(3, 3));
    }
}
