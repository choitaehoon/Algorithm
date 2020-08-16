package medium;

import java.util.Arrays;

public class Main1361 {

    public static void main(String[] args) {
//        System.out.println(validateBinaryTreeNodes(
//                4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}
//        ));
        System.out.println(validateBinaryTreeNodes(
                4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}
        ));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        for(int i = 0;i < n;i++) parent[i] = i;
        for(int i = 0;i < n;i++) {
            System.out.println(Arrays.toString(parent));
            if(leftChild[i] != -1) {
                int yl = find(parent, i);
                int xl = find(parent, leftChild[i]);
                if(yl == xl) return false;
                union(parent, xl, yl);
            }

            if(rightChild[i] != -1) {
                int yr = find(parent, i);
                int xr = find(parent, rightChild[i]);
                if(yr == xr) return false;
                union(parent, xr, yr);
            }

        }

        int dcon = 0;
        for(int i = 0;i < n;i++) {
            if(parent[i] == i) dcon++;
        }

        return dcon == 1;

    }

    public static int find(int[] parent, int x) {
        if(parent[x] != x) {
            x = parent[x];
        }
        return parent[x];
    }

    public static void union(int[] parent, int x, int y) {
        int xparent = find(parent, x);
        int yparent = find(parent, y);

        parent[xparent] = yparent;
    }

}
