package easy;

public class Main100 {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        return recursiveTree(p, q);
    }

    private static boolean recursiveTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;

        return recursiveTree(p.left, q.left) && recursiveTree(p.right, q.right);
    }

}
