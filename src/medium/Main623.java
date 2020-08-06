package medium;

public class Main623 {

    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return isZeroRoot(root, v);
        }

        preOrder(root, v, d, 1);
        return root;
    }

    private void preOrder(TreeNode root, int v, int d, int dIndex) {
        if (root == null)
            return;

        if (dIndex == d - 1) {
            TreeNode newNodeLeft = new TreeNode(v);
            TreeNode newNodeRight = new TreeNode(v);

            newNodeLeft.left = root.left;
            root.left = newNodeLeft;

            newNodeRight.right = root.right;
            root.right = newNodeRight;
            return;
        }

        preOrder(root.left, v, d,  dIndex + 1);
        preOrder(root.right, v, d, dIndex + 1);
    }

    private TreeNode isZeroRoot(TreeNode root, int v) {
        TreeNode newRoot = new TreeNode(v);
        newRoot.left = root;
        return newRoot;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
    }
}