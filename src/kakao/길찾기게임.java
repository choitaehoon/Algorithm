package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임 {

    static Node node;
    static Node[] nodes;
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
        )));
    }

    public static int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; ++i) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        Arrays.sort(nodes);

        node = new Node(nodes[0].id, nodes[0].x, nodes[0].y, null, null);

        for (int i = 1; i < nodes.length; ++i) {
            nodeAdd(node, nodes[i]);
        }

        preOrder(node);
        postOrder(node);

        int len = preOrderList.size();
        int[][] answer = new int[2][len];

        for (int i=0; i<len; ++i) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;
    }

    private static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        postOrderList.add(node.id);
    }

    private static void preOrder(Node node) {
        if (node == null) return;

        preOrderList.add(node.id);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void nodeAdd(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null)
                parent.left = child;
            else
                nodeAdd(parent.left, child);
        } else  {
            if (parent.right == null)
                parent.right = child;
            else
                nodeAdd(parent.right, child);
        }
    }
}

class Node implements Comparable<Node> {

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

    @Override
    public int compareTo(Node o) {
        int r = o.y - this.y;
        if (r != 0) return r;
        return this.x - o.x;
    }

}
