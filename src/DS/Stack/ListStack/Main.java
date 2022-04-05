// 자료구조 과제 #3 (60191363 장예지)
// 괄호 짝 맞추기
package DS.Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();
        String[] s1 = {"{", "{", "(", ")", "{", "(", ")", "}", "}", "}"};
        String[] s2 = {"{", "{", "(", ")", "{", "(", ")", "}", ")", "(", ")", "}"};

        bracket(stack, s1);
        bracket(stack, s2);
    }

    public static void bracket(ListStack<String> stack, String[] s) {
        int index = 0;

        for(int i=0; i < s.length; i++) {
            if(s[i] == "{" || s[i] == "(") {
                stack.push(s[i]);
            }
            else if ((stack.peek() == "{" && s[i] == "}") || (stack.peek() == "(" && s[i] == ")")) {
                stack.pop();
            }
            else {
                index = i;
                break;
            }
        }

        if(stack.isEmpty()) {
            System.out.println("괄호 짝이 맞다");
        }
        else {
            System.out.println("입력스트링의 " + (index + 1) + "번째 부분이 짝이 맞지 않습니다.");
        }
    }
}
