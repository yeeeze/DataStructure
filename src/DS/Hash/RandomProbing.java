// 자료구조 과제 #9 (60191363 장예지)
package DS.Hash;

import java.util.Random;

/**
 * 랜덤조사
 */
public class RandomProbing<K, V> {
    private int N = 0, M = 11; // 항목수 N, 테이블 크기 M
    private K[] a = (K[]) new Object[M];    // 해시테이블
    private V[] d = (V[]) new Object[M];    // key관련 데이터 저장

    private int hash(K key) {   // 해시코드
        return (key.hashCode() & 0x7fffffff) % M;   // 나눗셈 함수
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos;
        int crash = 0;

        Random rand = new Random();
        rand.setSeed(10);

        do {
            if (a[i] == null) {     // 삽입 위치 발견
                a[i] = key;
                d[i] = data;
                N++;

                if (crash != 0) {
                    System.out.println("입력값: " + data + ", 충돌 횟수: " + crash);
                }

                return;
            }
            if (a[i].equals(key)) {     // 이미 key 존재
                d[i] = data;
                return;
            }
            i = (initialpos + rand.nextInt(1000)) % M;
            crash += 1;
        } while (N < M);
    }

    public V get(K key) {   // 탐색 연산
        Random rand = new Random();
        rand.setSeed(10);   // 삽입 때와 같은 seed값 사용
        int initialpos = hash(key);     // 초기 위치
        int i = initialpos;

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return d[i];    // 탐색 성공
            }
            i = (initialpos + rand.nextInt(1000)) % M;  // i = 다음 위치
        }

        return null;    // 탐색 실패
    }

    public static void main(String[] args) {
        RandomProbing randomProbing = new RandomProbing<>();

        // 키 저장 순서 : 71, 23, 73, 49, 54, 89, 39
        randomProbing.put(71, 71);
        randomProbing.put(23, 23);
        randomProbing.put(73, 73);
        randomProbing.put(49, 49);
        randomProbing.put(54, 54);
        randomProbing.put(89, 89);
        randomProbing.put(39, 39);

        System.out.println();
        System.out.println("<해시테이블 출력>");
        for (int i = 0; i < randomProbing.M; i++) {
            System.out.print(i + ": " + randomProbing.a[i]);
            System.out.println();
        }
    }
}
