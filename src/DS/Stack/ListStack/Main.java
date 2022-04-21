// 자료구조 과제 #4 (60191363 장예지)
// 중위표기법 -> 후위표기법 변환 메소드
package DS.Stack.ListStack;

public class Main {
    public static void main(String[] args) {
        // 과제4 test
        String str2 = new String("A-B+C/D");
        System.out.println("\n" + str2);
        changeAfter(str2);

        str2 = new String("A/B-C*D");
        System.out.println("\n" + str2);
        changeAfter(str2);

        str2 = new String("A-B*C+D/E-F");
        System.out.println("\n" + str2);
        changeAfter(str2);

        str2 = new String("(A-B)*C-(D/(E+F))");
        System.out.println("\n" + str2);
        changeAfter(str2);
    }

    // 과제4
    private static void changeAfter(String str) {
        ListStack<Character> stack = new ListStack<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) > 64) {
                System.out.print(str.charAt(i));
            }
            else if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    char pop = stack.pop();
                    if(pop != '(' || pop != ')') {
                        System.out.print(pop);
                    }
                }
            }
            else if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                if(stack.isEmpty()) {
                    stack.push(str.charAt(i));
                }
                else {
                    int size = stack.size();

                    for(int j = 0; j < size; j++) {
                        if(stack.peek() == '(') {
                            break;
                        }
                        else {
                            System.out.print(stack.pop());
                        }
                    }
                    stack.push(str.charAt(i));
//                    if(stack.peek() == '(') {
//                        stack.push(str.charAt(i));
//                    }
//                    else {
//                        System.out.print(stack.pop());
//                        stack.push(str.charAt(i));
//                    }
                }
            }
            else if(str.charAt(i) == '*' || str.charAt(i) == '/') {
                if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    System.out.print(stack.pop());
                    stack.push(str.charAt(i));
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == '(') {
                stack.pop();
            }
            else {
                System.out.print(stack.pop());
            }
        }
    }

    // 과제3
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
