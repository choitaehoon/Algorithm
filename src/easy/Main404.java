package easy;

import java.util.ArrayList;
import java.util.List;

public class Main404 {

    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveTreeSum(root, "", result);
        return result.stream().reduce(0, Integer::sum);
    }

    private static void recursiveTreeSum(TreeNode node, String direction, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (direction.equals("left") && node.left == null && node.right == null)
            result.add(node.val);

        recursiveTreeSum(node.left, "left", result);
        recursiveTreeSum(node.right, "right", result);
    }

}
