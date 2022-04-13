// 자료구조 과제 #4 (60191363 장예지)
package DS.Stack.ListStack;

public class Node<E> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> node) {
        this.item = newItem;
        this.next = node;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
