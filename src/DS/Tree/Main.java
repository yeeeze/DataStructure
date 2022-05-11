// 자료구조 과제 #5 (60191363 장예지)

package DS.Tree;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(100, null, null);
        Node n2 = new Node(200, null, null);
        Node n3 = new Node(300, null, null);
        Node n4 = new Node(400, null, null);
        Node n5 = new Node(500, null, null);
        Node n6 = new Node(600, null, null);
        Node n7 = new Node(700, null, null);
        Node n8 = new Node(800, null, null);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);

        BinaryTree t = new BinaryTree();  // 이진 트리 객체 t 생성
        t.setRoot(n1);

        System.out.println("트리 노드 수 = " + t.size(t.getRoot()) + "\n트리 높이 = " + t.height(t.getRoot()));
        System.out.println();

        System.out.println("\n전위 순회: ");
        t.preorder(t.getRoot());
        System.out.println("\n중위 순회: ");
        t.inorder(t.getRoot());
        System.out.println("\n후위 순회: ");
        t.postorder(t.getRoot());
        System.out.println("\n레벨 순회: ");
        t.levelorder(t.getRoot());

        System.out.println();
        System.out.println();

        // 두번째 이진트리를 만들어 isEqual() test하기 위해 트리 하나 더 만듦
        Node n10 = new Node(100, null, null);
        Node n11 = new Node(200, null, null);
        Node n12 = new Node(300, null, null);
        Node n13 = new Node(400, null, null);
        Node n14 = new Node(500, null, null);
        Node n15 = new Node(600, null, null);
        Node n16 = new Node(700, null, null);
        Node n17= new Node(800, null, null);

        n10.setLeft(n11);
        n10.setRight(n12);
        n11.setLeft(n13);
        n11.setRight(n14);
        n12.setLeft(n15);
        n12.setRight(n16);
        n13.setLeft(n17);

        BinaryTree t2 = new BinaryTree();  // 이진 트리 객체 t 생성
        t2.setRoot(n10);

        System.out.println("동일성 검사: " + BinaryTree.isEqual(t.getRoot(), t2.getRoot()));
        System.out.println("---------------------------------------------------");
        System.out.println();

        /**
         * 과제 #5
         * 원본 이진트리와 복사한 이진트리에 대해 각각 전위순회 & 레벨순회 결과를 출력, 비교
         * isEqual() 메소드로 비교한 결과 출력
         */

        System.out.println("과제 #5");
        Node A = new Node("A", null, null);
        Node B = new Node("B", null, null);
        Node C = new Node("C", null, null);
        Node D = new Node("D", null, null);
        Node E = new Node("E", null, null);
        Node F = new Node("F", null, null);
        Node G = new Node("G", null, null);
        Node H = new Node("H", null, null);
        Node I = new Node("I", null, null);

        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(E);
        C.setLeft(F);
        C.setRight(G);
        F.setLeft(H);
        G.setRight(I);

        BinaryTree t3 = new BinaryTree();
        t3.setRoot(A);

        // 이진트리 복사
        BinaryTree cloneTree = t3.clone(t3.getRoot());

        System.out.println("전위 순회");
        t3.preorder(t3.getRoot());
        System.out.println();
        cloneTree.preorder(cloneTree.getRoot());
        System.out.println();

        System.out.println("레벨 순회");
        t3.levelorder(t3.getRoot());
        System.out.println();
        cloneTree.levelorder(cloneTree.getRoot());
        System.out.println();

        System.out.println("동일성 검사 : " + BinaryTree.isEqual(t3.getRoot(), cloneTree.getRoot()));
    }
}
