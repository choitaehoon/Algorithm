package medium;

import java.util.ArrayList;
import java.util.List;

public class Main429 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderSearch(0, result, root);
        return result;
    }

    private void levelOrderSearch(int level, List<List<Integer>> result, Node root) {
        if (root == null) return;

        if (level == result.size())
            result.add(new ArrayList<>());

        result.get(level).add(root.val);

        for (Node child : root.children) {
            levelOrderSearch(level + 1, result, child);
        }
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}