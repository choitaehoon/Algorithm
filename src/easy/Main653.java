package easy;

import java.util.HashSet;
import java.util.Set;

public class Main653 {

    public static void main(String[] args) {

    }

    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> key = new HashSet<>();
        return find(root, k, key);
    }

    private static boolean find(TreeNode root, int k, Set<Integer> key) {
        if(root == null)
            return false;

        if (key.contains(k - root.val))
            return true;

        key.add(root.val);

        return find(root.left, k, key) || find(root.right, k, key);
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