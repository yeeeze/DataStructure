package DS.List.SinglyLinkedList;

import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    protected Node head;    // 연결 리스트의 첫 노드 가리킴
    private int size;

    public SList() {
        this.head = null;
        this.size = 0;
    }

    // 탐색, 삽입, 삭제 연산을 위한 메소드 선언
    public int search(E target){    // target을 탐색
        Node p = head;

        for(int k = 0; k < size; k++) {
            if(target == p.getItem()) {
                return k;
            }
            p = p.getNext();
        }

        return -1;  // 탐색을 실패한 경우 -1 리턴
    }

    // 연결리스트 맨 앞에 새 노드 삽입
    public void insertFront(E newItem) {
        this.head = new Node(newItem, this.head);
        this.size++;
    }

    // 노드 p 바로 다음에 새 노드 삽입
    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        this.size++;
    }

    // 리스트의 첫 노드 삭제
    public void deleteFront() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        this.head = head.getNext();
        this.size--;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // p가 가리키는 노드의 다음 노드를 삭제
    public void deleteAfter(Node p) {
        if(p == null) {
            throw new NoSuchElementException();
        }
        if(p.getNext() == null) {
            System.out.println("마지막 노드입니다. 다음 노드를 삭제할 수 없습니다.");
            throw new NoSuchElementException();
        }
        Node next = p.getNext();
        p.setNext(next.getNext());
        next.setNext(null);
        this.size--;
    }

    public void print() {
        for(Node p = this.head; p != null; p = p.getNext()) {
            System.out.print(p.getItem()+"\t  ");
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
