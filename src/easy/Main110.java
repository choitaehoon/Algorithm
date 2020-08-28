package easy;

public class Main110 {

    static boolean isCheck = true;

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        searchRoot(root);
        return isCheck;
    }

    private int searchRoot(TreeNode root) {
        if(root == null) return 0;
        int left = searchRoot(root.left);
        int right = searchRoot(root.right);

        if (Math.abs(left - right) > 1) {
            isCheck = false;
        }

        return 1 + Math.max(left, right);
    }

}
