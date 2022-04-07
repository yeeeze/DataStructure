// 자료구조 과제 #2 (60191363 장예지)
package DS.List.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        // 17번 테스트용 코드
        SList<Integer> s1 = new SList<>();
        SList<Integer> s2 = new SList<>();
        SList<Integer> s3 = new SList<>();

        s1.insertFront(50);
        s1.insertFront(40);
        s1.insertFront(30);
        s1.insertFront(20);
        s1.insertFront(10);

        s2.insertFront(55);
        s2.insertFront(37);
        s2.insertFront(35);
        s2.insertFront(18);
        s2.insertFront(15);

        System.out.print("Sorted List 1: ");
        s1.print();
        System.out.print("Sorted List 2: ");
        s2.print();

        Node node = s3.mergeLists(s1.head, s2.head);
        s3.head = node;
        System.out.print("Merged List: ");
        s3.print();

        System.out.println("---------------------------------\n");

        // 20번 테스트용 코드
        SList<Integer> s4 = new SList<>();
        SList<Integer> s5 = new SList<>();
        SList<Integer> s6 = new SList<>();

        s4.insertFront(45);
        s4.insertFront(17);
        s4.insertFront(20);
        s4.insertFront(50);
        s4.insertFront(57);
        s4.insertFront(35);
        s4.insertFront(10);
        s4.insertFront(15);
        s4.insertFront(90);
        s4.insertFront(10);

        System.out.print("Single List: ");
        s4.print();
        System.out.println("k=" + 20 + "을 기준으로 두 개의 리스트로 분리: ");
        s4.splitList(s4.head, 20, s5, s6);
        s5.print();
        s6.print();
    }
}
