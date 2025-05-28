import java.util.*;

class Node {
    int x, y, idx;
    Node left, right;
    
    Node(int x, int y, int idx, Node left, Node right) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    int idx;
    int[][] result;
    
    public int[][] solution(int[][] nodeinfo) {
        // 두 팀으로 나눠서, 각 팀이 같은 곳을 다른 순서로 방문하도록 해서 먼저 순회한 팀이 승리
        // 각 노드의 (x, y) 좌표가 주어지고, 이진 트리 모양이다, 전위, 후위 순회를 반환
        int N = nodeinfo.length;
        Node[] nodes = new Node[N];
        
        for (int i = 0; i < N; i++) {
            int[] node = nodeinfo[i];
            nodes[i] = new Node(node[0], node[1], i + 1, null, null);
        }
        
        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y) return b.y - a.y;
            return a.x - b.x;
        });
        
        Node root = nodes[0];
        
        for (int i = 1; i < N; i++) {
            insert(root, nodes[i]);
        }
        
        result = new int[2][N];
        idx = 0;
        preOrder(root);
        idx = 0;
        postOrder(root);
        
        return result;
    }
    
    // 전위 순회
    void preOrder(Node root) {
        if (root != null) {
            result[0][idx++] = root.idx;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    // 후위 순회
    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result[1][idx++] = root.idx;
        }
    }
    
    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
}
