// 자료구조 과제 #9 (60191363 장예지)
package DS.Hash;

/**
 * 폐쇄주소방식 : 체이닝
 */
public class Chaining<K, V> {
    private int M = 11;     // 테이블 크기
    private Node[] a = new Node[M];     // 해시 테이블

    public static class Node {  // Node 클래스
        private Object key;
        private Object data;
        private Node next;

        public Node(Object newKey, Object newdata, Node ref) {
            this.key = newKey;
            this.data = newdata;
            this.next = ref;
        }

        public Object getKey() {
            return key;
        }

        public Object getData() {
            return data;
        }
    }

    private int hash(K key) {   // 해시 코드
        return (key.hashCode() & 0x7fffffff) % M;   // 나눗셈 연산
    }

    public V get(K key) {   // 탐색연산
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {    // 연결리스트 탐색
            if (key.equals(x.key)) {
                return (V) x.data;  // 탐색 성공
            }
        }
        return null;
    }

    private void put(K key, V data) {   // 삽입 연산
        int i = hash(key);

        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {    // 이미 key 존재
                x.data = data;  // 데이터만 갱신
                return;
            }
        }
        a[i] = new Node(key, data, a[i]);   // 연결리스트의 첫 노드로 삽입
    }

    public static void main(String[] args) {
        Chaining chaining = new Chaining();

        // 키 저장 순서 : 71, 23, 73, 49, 54, 89, 39
        chaining.put(71, 71);
        chaining.put(23, 23);
        chaining.put(73, 73);
        chaining.put(49, 49);
        chaining.put(54, 54);
        chaining.put(89, 89);
        chaining.put(39, 39);

        System.out.println("<해시테이블 출력>");
        for (int i = 0; i < chaining.M; i++) {
            System.out.print(i + ": ");
            Node x = chaining.a[i];
            while (x != null) {
                System.out.print(" -> [" + x.getKey() + "]");
                x = x.next;
            }
            System.out.println();
        }
    }
}
