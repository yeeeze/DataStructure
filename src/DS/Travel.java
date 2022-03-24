package DS;

// 3가지 관광 코스 순서를 출력하는 여행 프로그램
public class Travel {
    private Node start; // 시작 섬

    public Travel() {   // 여행 생성자
        this.start = null;
    }

    public class Node {
        private char name;  // 섬 이름
        private Node left, right;   // 섬 사이의 다리를 연결

        public Node(char newIsland, Node left, Node right) {
            this.name = newIsland;
            this.left = left;
            this.right = right;
        }
    }

    public Node map() { // 지도 만들기
        Node n1 = new Node('H', null, null);
        Node n2 = new Node('F', null, null);
        Node n3 = new Node('S', null, null);
        Node n4 = new Node('U', null, null);
        Node n5 = new Node('E', null, null);
        Node n6 = new Node('Z', null, null);
        Node n7 = new Node('K', null, null);
        Node n8 = new Node('N', null, null);
        Node n9 = new Node('A', null, null);
        Node n10 = new Node('Y', null, null);
        Node n11 = new Node('T', null, null);

        n1.left = n2;   n1.right = n3;
        n2.left = n4;   n2.right = n5;
        n3.left = n6;   n3.right = n7;
        n4.left = n8;   n5.left = n9;
        n7.right = n10; n9.right = n11;

        return n1;  // 시작 섬 리턴
    }

    public void A_Course(Node start) {    // A 코스
        if(start != null) {
            System.out.print(start.name + "-> ");
            A_Course(start.left);
            A_Course(start.right);
        }
    }

    public void B_Course(Node start) {
        if(start != null) {
            B_Course(start.left);
            System.out.print(start.name + "-> ");
            B_Course(start.right);
        }
    }

    public void C_Course(Node start) {
        if(start != null) {
            C_Course(start.left);
            C_Course(start.right);
            System.out.print(start.name + "-> ");
        }
    }

    public static void main(String[] args) {
        Travel travel = new Travel();
        travel.start = travel.map();

        System.out.print("A코스 : ");
        travel.A_Course(travel.start);

        System.out.print("\nB코스 : ");
        travel.B_Course(travel.start);

        System.out.print("\nC코스 : ");
        travel.C_Course(travel.start);
    }
}