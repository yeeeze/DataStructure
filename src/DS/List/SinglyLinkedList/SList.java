// 자료구조 과제 #2 (60191363 장예지)
package DS.List.SinglyLinkedList;

import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    protected Node head;    // 연결 리스트의 첫 노드 가리킴
    private int size;

    public SList() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
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

    // 과제 17번
    public Node mergeLists(Node p1, Node p2) {
        Node head = new Node(0, null);  // 비어있는 노드. mergeList의 첫번째 노드를 가리키는 역할
        Node p = head;

        while(p1 != null && p2 != null) {
            // compareTo: 기본형 객체 & string 객체에는 이미 compareTo()가 있음
            int c = p1.getItem().compareTo(p2.getItem());

            if(c < 0) {
                p.setNext(p1);
                p1 = p1.getNext();
            }
            else {
                p.setNext(p2);
                p2 = p2.getNext();
            }
            p = p.getNext();
        }

        if(p1 != null) {
            p.setNext(p1);
        }
        if(p2 != null) {
            p.setNext(p2);
        }

        return head.getNext();
    }

    // 과제 20번
    public void splitList(Node<Integer> p, int k, SList l1, SList l2){
        Node head1 = new Node(0, null);
        Node head2 = new Node(0, null);
        Node p1 = head1;    // l1 List의 마지막 노드를 가리킴
        Node p2 = head2;    // l2 List의 마지막 노드를 가리킴

        while (p != null) {
            int c = p.getItem().compareTo(k);
            if(c <= 0) {
                p1.setNext(p);
                p1 = p1.getNext();
            }
            else {
                p2.setNext(p);
                p2 = p2.getNext();
            }
            p = p.getNext();
        }

        p1.setNext(null);
        p2.setNext(null);
        l1.setHead(head1.getNext());
        l2.setHead(head2.getNext());
    }
}