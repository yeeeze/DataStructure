// 자료구조 과제 #3 (60191363 장예지)
// 괄호 짝 맞추기
package DS.Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        String str = new String("{{(){()}}}");
        System.out.println(str);
        checkPaired(str);

        str = new String("{{(){()})()}");
        System.out.println("\n" + str);
        checkPaired(str);

        str = new String("{{()(}}}");
        System.out.println("\n" + str);
        checkPaired(str);

        str = new String("{{(())}");
        System.out.println("\n" + str);
        checkPaired(str);

        str = new String(")}");
        System.out.println("\n" + str);
        checkPaired(str);
    }

    private static void checkPaired(String str) {
        ListStack<Character> stack = new ListStack<>();
        int mismatch = -1;

        for(int i = 0; i < str.length() && mismatch == -1; i++) {
            switch (str.charAt(i)) {
                case '(':
                case '{': stack.push(str.charAt(i)); break;
                case ')':
                    if(stack.isEmpty()) {
                        mismatch = i;
                    }
                    else if(stack.pop() != '(') {
                        mismatch = i;
                    }
                    break;

                case '}':
                    if(stack.isEmpty()) {
                        mismatch = i;
                    }
                    else if(stack.pop() != '{') {
                        mismatch = i;
                    }
                    break;
            }
        }

        if(mismatch != -1) {
            System.out.println(str.substring(0, mismatch) + "^^^부터 괄호 쌍이 맞지 않습니다.");
        }
        else if(!stack.isEmpty()) {
            System.out.println(str + "^^^부터 괄호 쌍이 맞지 않습니다.");
        }
        else {
            System.out.println("괄호 쌍이 맞습니다.");
        }
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
