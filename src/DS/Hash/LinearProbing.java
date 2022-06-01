// 자료구조 과제 #9 (60191363 장예지)
package DS.Hash;

/**
 * 선형조사
 */
public class LinearProbing<K, V> {
    private int M = 11; // 테이블 크기
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
                d[i] = data;    // key관련 데이터를 동일한 인덱스하에 저장

                if (crash != 0) {
                    System.out.println("입력값: " + data + ", 충돌 횟수: " + crash);
                }

                return;
            }
            if (a[i].equals(key)) {     // 이미 Key 존재:
                d[i] = data;    // 데이터만 갱신
                return;
            }
            i = (initialpos + j++) % M;   // i = 다음 위치
            crash+=1;
        } while (i != initialpos);  // 현재 i가 초기위치와 같게되면 루프 종료 (꽉 차서 한바퀴 돌았으니까)
    }

    public V get(K key) {   // 탐색 연산
        int initialpos = hash(key);
        int i = initialpos, j = 1;

        while (a[i] != null) {  // a[i]가 empty가 아니면
            if (a[i].equals(key)) {
                return d[i];    // 탐색 성공
            }
            i = (initialpos + j++) % M;     // i = 다음 위치
        }
        return null;    // 탐색 실패 (삽입이 안된 경우)
    }

    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing();

        // 키 저장 순서 : 71, 23, 73, 49, 54, 89, 39
        linearProbing.put(71, 71);
        linearProbing.put(23, 23);
        linearProbing.put(73, 73);
        linearProbing.put(49, 49);
        linearProbing.put(54, 54);
        linearProbing.put(89, 89);
        linearProbing.put(39, 39);

        System.out.println();
        System.out.println("<해시테이블 출력>");
        for (int i = 0; i < linearProbing.M; i++) {
            System.out.print(i + ": " + linearProbing.a[i]);
            System.out.println();
        }
    }
}
