// 자료구조 과제 #8 (60191363 장예지)
package DS.BHeap;

/**
 * 이진 힙의 노드 구현
 */
public class Entry<Key extends Comparable<Key>, Value> {
    private Key ky;
    private Value val;

    public Entry(Key newKey, Value newValue) {
        this.ky = newKey;
        this.val = newValue;
    }

    public Key getKey() {
        return ky;
    }

    public void setKey(Key ky) {
        this.ky = ky;
    }

    public Value getVal() {
        return val;
    }

    public void setVal(Value val) {
        this.val = val;
    }
}
