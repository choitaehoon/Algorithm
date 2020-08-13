package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1161 {

    public static void main(String[] args) {

    }

    public static int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelValue = new HashMap<>();
        recursiveMaxLevelSum(root, 1 ,levelValue);

        List<Map.Entry<Integer, Integer>> result = new ArrayList<>(levelValue.entrySet());
        result.sort((a1, a2) -> {
            int r = a2.getValue() - a1.getValue();
            if (r != 0) return r;

            return a1.getKey() - a2.getKey();
        });

        return result.get(0).getKey();
    }

    private static void recursiveMaxLevelSum(TreeNode node, int depth, Map<Integer, Integer> levelValue) {
        if (node == null) return;

        levelValue.put(depth, levelValue.getOrDefault(depth, 0) + node.val);

        recursiveMaxLevelSum(node.left, depth + 1, levelValue);
        recursiveMaxLevelSum(node.right, depth + 1, levelValue);
    }

}
