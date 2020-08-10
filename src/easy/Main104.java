package easy;

public class Main104 {


    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return maxDepthTreeNode(0, root);
    }

    private static int maxDepthTreeNode(int count, TreeNode node) {
        if (node == null) return count;

        return Math.max(maxDepthTreeNode(count + 1, node.left), maxDepthTreeNode(count + 1, node.right));
    }

}