package easy;

public class Main111 {

    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        return recursiveMinDepth(root, 1);
    }

    private static int recursiveMinDepth(TreeNode node, int depth) {
        if (node == null) return Integer.MAX_VALUE;

        if (node.left == null && node.right == null) {
            return depth;
        }

        return Math.min(recursiveMinDepth(node.left, depth + 1), recursiveMinDepth(node.right, depth + 1));
    }

}
