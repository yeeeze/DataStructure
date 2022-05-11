// 자료구조 과제 #6 (60191363 장예지)
package DS.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST t = new BST(50, "Apple");

        t.put(60, "Banana");
        t.put(20, "Melon");
        t.put(10, "Orange");
        t.put(40, "Tangerine");
        t.put(25, "Kiwi");
        t.put(15, "Grape");
        t.put(80, "Strawberry");
        t.put(70, "Cherry");
        t.put(35, "Lemon");

        System.out.println("1. 키와 값 10개 삽입 후 >>");
        t.print(t.root);
        System.out.println("\n\n높이 = " + t.height() + "\n");

        t.put(40, "Mango");
        System.out.println("t.get(40) = " + t.get(40));
        System.out.println("t.get(80) = " + t.get(80));
        System.out.println("t.get(77) = " + t.get(77));

        System.out.println("최소 키값 = " + t.min());

        System.out.println("\n2. 최소 키 삭제 후 >>");
        t.deleteMin();
        t.print(t.root);
        System.out.println();

        System.out.println("\n3. 15, 35 삭제 후 >>");
        t.delete(15);
        t.delete(35);
        t.print(t.root);
        System.out.println();

        System.out.println("\n4. 최대 키 삭제 후 >>");
        t.deleteMax();
        t.print(t.root);
        System.out.println();
    }
}
