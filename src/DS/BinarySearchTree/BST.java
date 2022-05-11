// 자료구조 과제 #6 (60191363 장예지)
package DS.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  이진 탐색 트리
 */
public class BST <Key extends Comparable<Key>, Value> {
    public Node root;
    public Node getRoot() {
        return this.root;
    }

    public BST(Key newId, Value newName) {
        this.root = new Node(newId, newName);
    }

    // 트리의 높이
    public int height() {
        return height(root) + 1;
    }

    // n을 루트로 하는 (서브)트리의 높이 리턴
    private int height(Node n) {
        if(n == null) {
            return -1;
        }

        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }

    // 트리 출력 : 세가지 순회 방식 사용
    public void print(Node root) {
        System.out.printf("\ninorder:\n");
        inorder(root);
        System.out.printf("\npreorder:\n");
        preorder(root);
        System.out.printf("\nlevelorder:\n");
        levelorder(root);
    }

    private void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;
        q.add(root);

        while(!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getId() + " ");
            if(t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }
        }
    }

    private void preorder(Node root) {
        if(root != null) {
            System.out.print(root.getId() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    private void inorder(Node root) {
        if(root != null) {
            inorder(root.getLeft());
            System.out.print(root.getId() + " ");
            inorder(root.getRight());
        }
    }

    // 트리에서 k값을 갖는 노드를 탐색 & Value 리턴
    public Value get(Key k) {
        return get(root, k);
    }

    // n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 탐색 & Value 리턴
    public Value get(Node n, Key k) {
        if(n == null) {
            return null;    // k를 발견 못함
        }

        int t = n.getId().compareTo(k);

        if(t > 0) {     // 왼쪽 서브 트리 탐색
            return get(n.getLeft(), k);
        }
        else if(t < 0) {    // 오른쪽 서브 트리 탐색
            return get(n.getRight(), k);
        }
        else {  // k를 가진 노드 발견
            return (Value) n.getName();
        }
    }

    // 트리에 노드(k, v)를 삽입
    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    // n을 루트로 하는 (서브)트리에 노드 (k, v)를 삽입
    private Node put(Node n, Key k, Value v) {
        if(n == null) {
            return new Node(k, v);
        }

        int t = n.getId().compareTo(k);
        if(t > 0) {     // 왼쪽 서브 트리에 삽입
            n.setLeft(put(n.getLeft(), k, v));
        }
        else if(t < 0) {    // 오른쪽 서브 트리에 삽입
            n.setRight(put(n.getRight(), k, v));
        }
        else {      // t == 0, id가 k인 노드가 이미 트리에 존재
            n.setName(v);
        }

        return n;
    }

    // 트리에서 최소값을 갖는 노드의 Key를 리턴
    public Key min() {
        if(root == null) {
            return null;
        }

        return (Key) min(root).getId();
    }

    // n을 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 리턴
    private Node min(Node n) {
        if(n.getLeft() == null) {
            return n;
        }
        return min(n.getLeft());
    }

    // 트리에서 최소값을 갖는 노드를 삭제
    public void deleteMin() {
        if(root == null) {
            System.out.println("empty 트리");
        }
        root = deleteMin(root);
    }

    // n을 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 삭제
    private Node deleteMin(Node n) {
        // if(n의 왼쪽 자식 == null) n의 오른쪽 자식 리턴
        if(n.getLeft() == null) {
            return n.getRight();    // if(오른쪽 자식이 없으면) null 리턴 되면서 setLeft로 루트에 연결되면서 삭제됨
        }

        // if(n의 왼쪽 자식 != null) n의 왼쪽 자식으로 재귀 호출
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    // 트리에서 k값을 갖는 노드를 삭제
    public void delete(Key k) {
        root = delete(root, k);
    }

    // n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 삭제
    public Node delete(Node n, Key k) {
        if(n == null) {
            return null;
        }

        int t = n.getId().compareTo(k);
        if(t > 0) {
            n.setLeft(delete(n.getLeft(), k));
        }
        else if(t < 0) {
            n.setRight(delete(n.getRight(), k));
        }
        else {  // if(t == 0) 삭제할 노드 발견!
            if(n.getRight() == null) {      // case 0, 1
                return n.getLeft();
            }
            if(n.getLeft() == null) {       // case 1
                return n.getRight();
            }

            Node target = n;    // case 2
            // 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
            n = min(target.getRight());
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }

        return n;
    }

    public void deleteMax() {
        if(this.root == null) {
            System.out.println("empty 트리");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node n) {
        if (n.getRight() == null) {
            return n.getLeft();
        }

        n.setRight(deleteMax(n.getRight()));
        return n;
    }
}
