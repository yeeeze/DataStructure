// 자료구조 과제 #8 (60191363 장예지)
package DS.BHeap;

public class Main {
    public static void main(String[] args) {
        Entry[] a = new Entry[16];
//        a[1] = new Entry(80, "1");
//        a[2] = new Entry(40, "2");
//        a[3] = new Entry(70, "3");
//        a[4] = new Entry(30, "4");
//        a[5] = new Entry(60, "5");
//        a[6] = new Entry(20, "6");
//        a[7] = new Entry(50, "7");
//        a[8] = new Entry(10, "8");

        BHeap h = new BHeap(a, 0);  // 힙 객체 생성
        System.out.println("힙 만들기 전: ");

        System.out.print("80 삽입 : ");
        h.insert(80, 80);
        h.print();

        System.out.print("40 삽입 : ");
        h.insert(40, 40);
        h.print();

        System.out.print("70 삽입 : ");
        h.insert(70, 70);
        h.print();

        System.out.print("30 삽입 : ");
        h.insert(30, 30);
        h.print();

        System.out.print("60 삽입 : ");
        h.insert(60, 60);
        h.print();

        System.out.print("20 삽입 : ");
        h.insert(20, 20);
        h.print();

        System.out.print("50 삽입 : ");
        h.insert(50, 50);
        h.print();

        System.out.print("10 삽입 : ");
        h.insert(10, 10);
        h.print();
    }
}
