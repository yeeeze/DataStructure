// 자료구조 과제 #8 (60191363 장예지)
package DS.BHeap;

/**
 * 이진힙 구현
 */
public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a;  // a[0]은 사용 안 함
    private int N;  // 힙 크기

    public BHeap(Entry[] harray, int initialSize) {
        this.a = harray;
        this.N = initialSize;
    }

    public int size() {
        return this.N;
    }

    // 키 비교
    private boolean greater(int i, int j) {
        return a[j].getKey().compareTo(a[i].getKey()) < 0;  // a[i] > a[j]
    }

    private void swap(int i, int j) {
        Entry temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print() {
        for (int i = 1; i < N + 1; i++) {
            System.out.printf("[" + a[i].getKey() + " " + a[i].getVal() + "] ");
        }
        System.out.println();
    }

    // createheap, 삽입, 최솟값 삭제, downheap, upheap

    // 초기 힙 만들기
    public void createHeap() {
        for (int i = N / 2; i > 0; i--) {
            downHeap(i);
        }
    }

    private void downHeap(int i) {
        while (2 * i <= N) {
            int k = 2 * i;
            if(k < N && greater(k, k + 1)) {
                k++;
            }
            if(!greater(i, k)) {
                break;
            }
            else {
                swap(i, k);
            }
            i = k;
        }
    }

    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey, newValue);
        a[++N] = temp;
        upheap(N);
    }

    private void upheap(int j) {
        while (j > 1 && greater(j / 2, j)) {
            swap(j/2, j);
            j = j / 2;
        }
    }

    public Entry deleteMin() {
        Entry min = a[1];
        swap(1, N--);
        a[N + 1] = null;
        downHeap(1);
        return min;
    }
}
