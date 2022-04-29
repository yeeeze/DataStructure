package Tree;

public class Node <Key extends Comparable<Key>>{
    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    // 노드 생성자
    public Node(Key newItem, Node lf, Node rt) {
        this.item = newItem;
        this.left = lf;
        this.right = rt;
    }

    public Key getItem() {
        return item;
    }

    public void setItem(Key item) {
        this.item = item;
    }

    public Node<Key> getLeft() {
        return left;
    }

    public void setLeft(Node<Key> left) {
        this.left = left;
    }

    public Node<Key> getRight() {
        return right;
    }

    public void setRight(Node<Key> right) {
        this.right = right;
    }
}
