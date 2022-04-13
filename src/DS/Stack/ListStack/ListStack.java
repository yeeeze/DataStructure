// 자료구조 과제 #4 (60191363 장예지)
package DS.Stack.ListStack;

import java.util.EmptyStackException;

// 단순연결리스트로 구현한 스택
public class ListStack<E> {
    private Node<E> top;    // 스택 top 항목을 가진 Node를 가리킴
    private int size;   // 스택의 항목 수

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    // 스택 top 항목만을 리턴
    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return this.top.getItem();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 스택 push 연산
    public void push(E newItem) {
        // top 노드 앞에 새 노드 삽입
        Node newNode = new Node(newItem, this.top);
        this.top = newNode; // top이 새 노드 가리킴
        this.size++;    // 스택 항목 수 1 증가
    }

    // 스택 pop 연산
    public E pop() {
        //underflow 시 프로그램 정지
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E topItem = this.top.getItem();
        this.top = this.top.getNext();  // top이 top 바로 아래 항목을 가리킴
        this.size--;    // 스택 항목수를 1 감소

        return topItem;
    }

    public void print() {
        for(Node p = this.top; p != null; p = p.getNext()) {
            System.out.print(p.getItem() + " ");
        }
        System.out.println();
    }
}
