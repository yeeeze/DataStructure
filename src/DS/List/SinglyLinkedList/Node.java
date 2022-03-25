package DS.List.SinglyLinkedList;

public class Node<E extends Comparable<E>>{
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> p){
        this.item = newItem;
        this.next = p;
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
