package easy;

public class Main101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return searchGo(root, root);
    }

    private static boolean searchGo(TreeNode nodeOne, TreeNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) return true;
        if (nodeOne == null || nodeTwo == null) return false;

        return (nodeOne.val == nodeTwo.val) && searchGo(nodeOne.left, nodeTwo.right) && searchGo(nodeTwo.right, nodeOne.left);
    }

}