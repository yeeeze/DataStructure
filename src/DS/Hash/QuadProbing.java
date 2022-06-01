// 자료구조 과제 #9 (60191363 장예지)
package DS.Hash;

/**
 * 이차조사
 */
public class QuadProbing<K, V> {
    private int N = 0, M = 11; // 항목수 N, 테이블 크기 M
    private K[] a = (K[]) new Object[M];    // 해시테이블
    private V[] d = (V[]) new Object[M];    // key관련 데이터 저장

    private int hash(K key) {   // 해시코드
        return (key.hashCode() & 0x7fffffff) % M;   // 나눗셈 함수
    }

    private void put(K key, V data) {   // 삽입 연산
        int initialpos = hash(key);     // 초기 위치
        int i = initialpos, j = 1;
        int crash = 0;

        do {
            if (a[i] == null) {     // 삽입 위치 발견
                a[i] = key;     // key를 해시테이블에 저장
                d[i] = data;
                N++;    // key 관련 데이터 저장

                if (crash != 0) {
                    System.out.println("입력값: " + data + ", 충돌 횟수: " + crash);
                }

                return;
            }
            if (a[i].equals(key)) {     // 이미 key 존재
                d[i] = data;        // data 데이터만 갱신
                return;
            }
            i = (initialpos + j * j) % M;   // i = 다음 위치
            j++;
            crash++;
        } while (N < M);    //  full 체크
    }

    public V get(K key) {   // 탐색 연산
        int initialpos = hash(key);
        int i = initialpos, j = 1;

        while (a[i] != null) {  // a[i]가 empty가 아니면
            if (a[i].equals(key)) {
                return d[i];    // 탐색 성공
            }
            i = (initialpos + j * j) % M;   // i = 다음 위치
            j++;
        }
        return null;    // 탐색 실패
    }

    public static void main(String[] args) {
        QuadProbing quadProbing = new QuadProbing();

        // 키 저장 순서 : 71, 23, 73, 49, 54, 89, 39
        quadProbing.put(71, 71);
        quadProbing.put(23, 23);
        quadProbing.put(73, 73);
        quadProbing.put(49, 49);
        quadProbing.put(54, 54);
        quadProbing.put(89, 89);
        quadProbing.put(39, 39);

        System.out.println();
        System.out.println("<해시테이블 출력>");
        for (int i = 0; i < quadProbing.M; i++) {
            System.out.print(i + ": " + quadProbing.a[i]);
            System.out.println();
        }
    }
}
