package DS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// A에서 C로 이동하는 하노이탑 알고리즘
public class Hanoi {
    private static int count;
    public static StringBuilder sb = new StringBuilder();

    public static void move(int n, String start, String to) {
        sb.append("원반 " + n + "을 " + start + "에서 " + to + "로 이동\n");
        count++;
    }

    public static void hanoi(int n, String start, String via, String to) {
        if(n == 1) {
            move(n, start, to);
            return;
        }
        hanoi(n-1, start, to, via);
        move(n, start, to);
        hanoi(n-1, via, start, to);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, "A", "B", "C");
        System.out.println("원판을 움직인 총 횟수 : " + count);
        System.out.println(sb.toString());
    }
}
