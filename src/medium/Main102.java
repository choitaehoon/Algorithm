package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> mapResult = new HashMap<>();
        recursiveLevelOrder(root, 0, mapResult);

        return mapResultGet(mapResult);
    }

    private void recursiveLevelOrder(TreeNode node, int depth, Map<Integer, List<Integer>> mapResult) {
        if (node == null) return;

        List<Integer> store = mapResult.getOrDefault(depth, new ArrayList<>());
        store.add(node.val);
        mapResult.put(depth, store);

        recursiveLevelOrder(node.left, depth + 1, mapResult);
        recursiveLevelOrder(node.right, depth + 1, mapResult);
    }

    private List<List<Integer>> mapResultGet(Map<Integer, List<Integer>> mapResult) {

        List<List<Integer>> result = new ArrayList<>();
        List<Map.Entry<Integer, List<Integer>>> mapResultStore = new ArrayList<>(mapResult.entrySet());
        mapResultStore.sort((a1, a2) -> a1.getKey() - a2.getKey());

        for (Map.Entry<Integer, List<Integer>> value : mapResultStore)
            result.add(value.getValue());

        return result;
    }

}