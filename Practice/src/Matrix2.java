public class Matrix2
{
    static class Matrix {
        int row, col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] temp;

    static int 곱셈횟수최소값(Matrix[] a, int start, int end) throws Exception {
        if(temp == null) temp = new int[a.length][a.length];
        if(temp[start][end] != 0) return temp[start][end];
        System.out.println("(start, end) "+start+" "+end);
        if (start == end) return 0;
        int 최소값 = Integer.MAX_VALUE;
        for (int middle = start; middle < end; ++middle) {
            int 횟수 = 곱셈횟수최소값(a, start, middle);
            횟수 += 곱셈횟수최소값(a, middle + 1, end);
            횟수 += a[start].row * a[middle].col * a[end].col;
            if (횟수 < 최소값) 최소값 = 횟수;
        }
        return temp[start][end] = 최소값;
    }

    static int 곱셈횟수최대값(Matrix[] a, int start, int end) throws Exception {
        if (start == end) return 0;
        int 최대값 = 0;
        for (int middle = start; middle < end; ++middle) {
            int 횟수 = 곱셈횟수최소값(a, start, middle);
            횟수 += 곱셈횟수최소값(a, middle + 1, end);
            횟수 += a[start].row * a[middle].col * a[end].col;
            if (횟수 > 최대값) 최대값 = 횟수;
        }
        return 최대값;
    }

    public static void main(String[] args) throws Exception {
        Matrix[] a = new Matrix[]{new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50)};
        System.out.println(곱셈횟수최소값(a, 0, a.length - 1));
//        System.out.println(곱셈횟수최대값(a, 0, a.length - 1));
    }
}
