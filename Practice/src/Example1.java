public class Example1 {
    static class Matrix {
        int row, col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] 최소값저장;

    static int 곱셈횟수최소값(Matrix[] a, int start, int end) throws Exception {
        if (최소값저장 == null) 최소값저장 = new int[a.length][a.length]; //최초로 실행되고 나중에 null이 아니니까 실행 안된다.
        if (최소값저장[start][end] != 0) return 최소값저장[start][end];
        if (start == end) return 0; //곱 할게 없으면 return 0;
        System.out.printf("(%d, %d) ", start, end);
        int 최소값 = Integer.MAX_VALUE;
        for (int middle = start; middle < end; ++middle) {
            System.out.printf("%d\n",middle);
            int 횟수 =0;
            if(start != middle)
                횟수 = 곱셈횟수최소값(a, start, middle);
            횟수 += 곱셈횟수최소값(a, middle + 1, end);
            횟수 += a[start].row * a[middle].col * a[end].col;
            if (횟수 < 최소값) 최소값 = 횟수;
        }
        return 최소값저장[start][end] = 최소값;
    }

    public static void main(String[] args) throws Exception {
        Matrix[] a = new Matrix[]{new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
                                  new Matrix(50, 3)};
        System.out.println(곱셈횟수최소값(a, 0, a.length - 1));
    }
}