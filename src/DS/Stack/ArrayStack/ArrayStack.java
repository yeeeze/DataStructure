package DS.Stack.ArrayStack;

import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E s[];  // 스택을 위한 배열
    private int top;    // 스택의 top 항목의 배열원소 인덱스

    // 스택 생성자
    public ArrayStack() {
        this.s = (E[]) new Object[1];   // 초기에 크기가 1인 배열 생성
        this.top = -1;
    }

    // 스택 top 항목의 내용만을 리턴
    public E peek() {
        // underflow시 프로그램 정지
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return s[top];
    }

    // 스택에 있는 항목의 수를 리턴
    public int size() {
        return top + 1;
    }

    // 스택이 empty이면 true 리턴
    public boolean isEmpty() {
        return (top == -1);
    }

    // push 연산
    public void push(E newItem) {
        // 빈 공간이 없으면 스택을 2배로 확장
        if(size() == s.length) {
            resize(2 * s.length);
        }

        // 새 항목을 push
        s[++top] = newItem;
    }

    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 t 생성
        Object[] t = new Object[newSize];

        // 배열 s를 배열 t로 복사
        for(int i=0; i<s.length; i++) {
            t[i] = s[i];
        }

        // 배열 t를 배열 s로
        s = (E[]) t;
    }

    // pop 연산
    public E pop() {
        // underflow시 프로그램 정지
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        // top의 항목을 pop & null로 초기화
        E item = s[top];
        s[top--] = null;

        // 스택이 배열 항목의 1/4만 차지할 경우 배열을 1/2 크기로 축소
        if(size() > 0 && size() == s.length/4) {
            resize(s.length / 2);
        }

        return item;
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("스택이 비어있음");
        }

        for(int i = 0; i < size(); i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
}
