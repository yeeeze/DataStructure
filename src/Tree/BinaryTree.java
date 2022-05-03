// 자료구조 과제 #5 (60191363 장예지)

package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    // 트리 생성자
    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node newRoot) {
        root = newRoot;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // root를 루트로 하는 (서브)트리의 노드 수
    public int size(Node root) {
        if(root == null) {
            return 0;   // null이면 0 리턴
        }
        else {
            return (1 + size(root.getLeft()) + size(root.getRight()));
        }
    }

    // root를 루트로 하는 (서브)트리의 높이
    public int height(Node root) {
        if(root == null) {
            return 0;
        }
        else {
            return (1 + Math.max(height(root.getLeft()), height(root.getRight())));
        }
    }

    // 전위 순회
    public void preorder(Node root) {
        if(root != null) {
            System.out.print(root.getItem() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    // 중위 순회
    public void inorder(Node root) {
        if(root != null) {
            inorder(root.getLeft());
            System.out.print(root.getItem() + " ");
            inorder(root.getRight());
        }
    }

    // 후위 순회
    public void postorder(Node root) {
        if(root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getItem() + " ");
        }
    }

    // 레벨 순회
    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;

        q.add(root);
        while(!q.isEmpty()) {
            t = q.remove(); // 큐의 맨 앞 노드 제거
            System.out.print(t.getItem() + " ");  // 제거 노드 출력(방문)

            if(t.getLeft() != null) {
                q.add(t.getLeft());     // 큐에 왼쪽 자식 삽입
            }
            if(t.getRight() != null) {
                q.add(t.getRight());    // 큐에 오른쪽 자식 삽입
            }
        }
    }

    // 두 트리의 동일성 검사 (전위 순회)
    public static boolean isEqual(Node n, Node m) {
        // 둘다 null이면 true, 아니면 false
        if(n == null || m == null) {
            return n == m;
        }
        // 둘다 null이 아니면 item 비교 (현재 노드 먼저 방문해서 비교)
        if(n.getItem().compareTo(m.getItem()) != 0) {
            return false;
        }

        // item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
        return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
    }

    /**
     * 과제 #5
     * 이진트리를 복사하는 메소드
     */
    public BinaryTree clone(Node root) {
        BinaryTree<Key> newTree = new BinaryTree<>();

        newTree.setRoot(root);
        return newTree;
    }
}
