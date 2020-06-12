package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임 {

    static Node node;
    static List<Node> nodeList = new ArrayList<>();
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
        )));
    }

    public static int[][] solution(int[][] nodeinfo) {

        for (int i = 0; i < nodeinfo.length; ++i) {
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }

        nodeList.sort((a1, a2) -> {
            int r = a2.y - a1.y;
            if (r != 0) return r;

            return a1.x - a2.x;
        });

        node = new Node(nodeList.get(0).id, nodeList.get(0).x, nodeList.get(0).y, null, null);

        for (int i = 1; i < nodeList.size(); ++i)
            rootAdd(node, nodeList.get(i));

        preOrder(node);
        postOrder(node);

        System.out.println(postOrderList.size());
        int len = preOrderList.size();
        int[][] answer = new int[2][len];
        for (int i = 0; i < len; ++i) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;
    }

    private static void rootAdd(Node parent, Node child) {
        if (parent.x < child.x) {
            if (parent.right == null)
                parent.right = child;
            else
                rootAdd(parent.right, child);
        } else {
            if (parent.left == null)
                parent.left = child;
            else
                rootAdd(parent.left, child);
        }
    }

    public static void preOrder(Node node) {
        if (node == null) return;

        preOrderList.add(node.id);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        postOrderList.add(node.id);
    }
}

class Node {

    int id;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int id, int x, int y, Node left, Node right) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}
