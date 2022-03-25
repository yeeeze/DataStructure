package DS.List;

import java.util.NoSuchElementException;

public class ArrList<E> {
    private E a[];  // 리스트의 항목들을 저장할 배열
    private int size;   // 리스트의 항목 수

    // 생성자
    public ArrList() {
        this.a = (E[]) new Object[1];   // 최초로 1개의 원소를 가진 배열 생성
        this.size = 0;  // 항목 수를 0으로 초기화
    }

    // 탐색, 삽입, 삭제 연산을 위한 메소드 선언

    // k번째 항목을 리턴, 단순히 읽기만 한다.
    public E peek(int k) {
        // underflow 경우에 프로그램 정지
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        try {
            return a[k];
        } catch (ArrayIndexOutOfBoundsException e) {    // k > size 경우 예외처리
            throw e;
        }
    }

    // 리스트가 empty이면 true 리턴
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 가장 뒤에 새 항목 삽입
    public void insertLast(E newItem) {
        if(size == a.length) {  // 배열에 빈 공간이 없으면
            resize(2 * a.length);   // 배열 크기 2배로 확장
        }
        a[size++] = newItem;    // 새 항목 삽입
    }

    // 새 항목을 k-1번째 항목 다음에 삽입
    public void insert(E newItem, int k) {
        //  배열에 빈 공간이 없으면 배열 크기 2배로 확장
        if(size == a.length) {
            resize(2 * a.length);
        }
        // 한 칸씩 뒤로 이동
        for(int i=size-1; i>=k; i--) {
            a[i+1] = a[i];
        }

        a[k] = newItem;
        size++;
    }

    // 배열 크기 조절
    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 t 생성
        Object[] t = new Object[newSize];

        // 배열 a를 배열 t로 복사
        for(int i=0; i<size; i++) {
            t[i] = a[i];
        }

        // 배열 t를 배열 a로
        a = (E[]) t;
    }

    // k번째 항목 삭제 & 반환
    public E delete(int k) {
        // underflow 경우에 프로그램 정지
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = a[k];

        // 한 칸씩 앞으로 이동
        for(int i=k; i<size; i++) {
            a[i] = a[i + 1];
        }
        size--;

        // 배열에 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
        if (size > 0 && size == a.length / 4) {
            resize(a.length/2);
        }

        return item;
    }

    public void print() {
        for(E e : this.a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrList<String> s = new ArrList<>();

        s.insertLast("apple");  s.print();
        s.insertLast("orange"); s.print();
        s.insertLast("cherry"); s.print();
        s.insertLast("pear"); s.print();
        s.insert("grape", 1); s.print();
        s.insert("lemon", 4); s.print();
        s.insertLast("kiwi"); s.print();

        s.delete(4); s.print();
        s.delete(0); s.print();
        s.delete(0); s.print();
        s.delete(3); s.print();
        s.delete(0); s.print();

        System.out.println("1번째 항목은 " + s.peek(1)+"이다.");
        System.out.println();

        s.peek(4);
    }

}
