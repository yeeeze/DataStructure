package Tree;

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
}
