package easy;

public class Main112 {

    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        return recursivePathSum(root, 0, sum);
    }

    private static boolean recursivePathSum(TreeNode node, int pathSum, int sum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null)
            return pathSum + node.val == sum;

        return recursivePathSum(node.left, pathSum + node.val, sum) || recursivePathSum(node.right, pathSum + node.val, sum);
    }

}
