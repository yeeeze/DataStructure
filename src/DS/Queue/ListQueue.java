package DS.Queue;

import DS.Stack.ListStack.Node;

import java.util.NoSuchElementException;

public class ListQueue <E> {
    private Node<E> front, rear;
    private int size;

    public ListQueue() {
        front = rear = null;
        size = 0;
    }

    // 큐의 항목 수를 리턴
    public int size() {
        return this.size;
    }

    // 큐가 empty이면 true 리턴
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(E newItem) {
        // 새 노드 생성
        Node newNode = new Node(newItem, null);

        // 큐가 empty이면 front도 newNode를 가리키게 함
        // 그렇지않으면 rear의 next를 newNode를 가리키게 함
        if(isEmpty()) {
            this.front = newNode;
        }
        else {
            this.rear.setNext(newNode);
        }

        rear = newNode; // 마지막 rear가 newNode를 가리킴
        size++; // 큐 항목 수 1 증가
    }

    public E remove() {
        // underflow 시 프로그램 정지
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        E frontItem = front.getItem();
        front = front.getNext();

        size--;
        if(isEmpty()) {
            rear = null;
        }

        return frontItem;
    }

    public void print() {
        if(front == null) {
            System.out.print("큐가 empty임");
        }
        for(Node p = front; p != null; p = p.getNext()) {
            System.out.print(p.getItem() + " ");
        }
        System.out.println();
    }
}
