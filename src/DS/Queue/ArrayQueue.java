package DS.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue <E>{
    private E[] q;  // 큐를 위한 배열
    private int front, rear, size;

    // 큐 생성자

    public ArrayQueue() {
        q = (E[]) new Object[2];    // 초기에 크기가 2인 배열 생성
        front = rear = size = 0;
    }

    // 큐에 있는 항목의 수를 리턴
    public int size() {
        return size;
    }

    // 큐가 empty이면 true를 리턴
    public boolean isEmpty() {
        return size == 0;
    }

    // 큐에 항목 삽입
    public void add(E newItem) {
        // 큐가 full(=비어있는 원소가 1개뿐)인 경우 큐의 크기를 2배 확장
        if((rear + 1) % q.length == front) {
            resize(2 * q.length);
        }

        rear = (rear + 1) % q.length;
        q[rear] = newItem;

        size++;
    }

    // 큐에서 항목 삭제
    public E remove() {
        // underflow 경우에 프로그램 정지
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        front = (front + 1) % q.length; // 빈 공간에서 맨 앞의 항목으로 변경
        E item = q[front];

        q[front] = null;    // print시 항목 없음을 확인하기 위해
        size--;

        // 큐의 항목 수가 배열 크기의 1/4만 차지하면 큐 배열을 1/2 크기로 축소
        if(size > 0 && size == q.length/4) {
            resize(q.length/2);
        }

        return item;
    }

    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 t 생성
        Object[] t = new Object[newSize];

        // 배열 q의 항목들을 배열 t[1]로부터 복사
        for(int i = 1, j = front + 1; i < size + 1; i++, j++) {
            t[i] = q[j % q.length];
        }

        front = 0;
        rear = size;

        // 배열 t를 배열 q로
        q = (E[]) t;
    }

    public void print() {
        for(E que: q) {
            System.out.print(que + " ");
        }
        System.out.println();
    }
}
