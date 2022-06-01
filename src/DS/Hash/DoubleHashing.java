// 자료구조 과제 #9 (60191363 장예지)
package DS.Hash;

/**
 * 이중해싱
 */
public class DoubleHashing<K, V> {

    private int N = 0, M = 11; // 항목수 N, 테이블 크기 M
    private K[] a = (K[]) new Object[M];    // 해시테이블
    private V[] dt = (V[]) new Object[M];    // key관련 데이터 저장

    private int hash(K key) {   // 해시코드
        return (key.hashCode() & 0x7fffffff) % M;   // 나눗셈 함수
    }

    private void put(K key, V data) {
        int initialpos = hash(key); // 초기 위치
        int i = initialpos;
        int j = 1;
        int d = (7 - (int) key % 7);    // 두번째 해시 함수, d(key) = 7 - key % 7
        int crash = 0;

        do {
            if (a[i] == null) {     // 삽입 위치 발견
                a[i] = key;     // key를 해시테이블에 저장
                dt[i] = data;   // key 관련 데이터 저장
                N++;

                if (crash != 0) {
                    System.out.println("입력값: " + data + ", 충돌 횟수: " + crash);
                }

                return;
            }
            if (a[i].equals(key)) {     // 이미 key 존재
                dt[i] = data;   // 데이터만 갱신
                return;
            }
            i = (initialpos + j * d) % M;   // i = 다음 위치
            j++;
            crash++;
        } while (N < M);
    }

    public V get(K key) {
        int initialpos = hash(key);     // 초기 위치
        int i = initialpos;
        int j = 1;
        int d = (7 - (int) key % 7);

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return dt[i];   // 탐색 성공
            }
            i = (initialpos + j * d) % M;
            j++;
        }
        return null;    // 탐색 실패
    }

    public static void main(String[] args) {
        DoubleHashing doubleHashing = new DoubleHashing();

        // 키 저장 순서 : 71, 23, 73, 49, 54, 89, 39
        doubleHashing.put(71, 71);
        doubleHashing.put(23, 23);
        doubleHashing.put(73, 73);
        doubleHashing.put(49, 49);
        doubleHashing.put(54, 54);
        doubleHashing.put(89, 89);
        doubleHashing.put(39, 39);

        System.out.println();
        System.out.println("<해시테이블 출력>");
        for (int i = 0; i < doubleHashing.M; i++) {
            System.out.print(i + ": " + doubleHashing.a[i]);
            System.out.println();
        }
    }
}
