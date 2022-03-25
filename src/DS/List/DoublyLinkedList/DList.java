package DS.List.DoublyLinkedList;

import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode head, tail;
    protected int size;

    public DList() {
        this.head = new DNode(null, null, null);
        this.tail = new DNode(null, head, null);    // tail의 이전 노드를 head로
        this.head.setNext(tail);    // head의 다음 노드를 tail로
        this.size = 0;
    }

    // 탐색, 삽입, 삭제 연산을 위한 메소드 선언
    // p가 가리키는 노드 앞에 삽입
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        this.size++;
    }
    // p가 가리키는 노드 뒤에 삽입
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        this.size++;
    }
    // x가 가리키는 노드 삭제
    public void delete(DNode x) {
        if(x == null) {
            throw new NoSuchElementException();
        }

        DNode p = x.getPrevious();
        DNode t = x.getNext();
        p.setNext(t);
        t.setPrevious(p);
        this.size--;
    }

    public void print() {
        if(this.size > 0) {
            for(DNode p = head.getNext(); p != tail; p = p.getNext()) {
                System.out.print(p.getItem() + "\t ");
            }
        }
        else {
            System.out.println("리스트 비어있음");
        }
        System.out.println();
    }
}
