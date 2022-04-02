package DS.Stack.ListStack;

import DS.Stack.ArrayStack.ArrayStack;

public class Main {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();

        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        stack.print();

        System.out.println(stack.peek());
        stack.push("pear");
        stack.print();

        stack.pop();
        stack.print();

        System.out.println(stack.peek());
        stack.push("grape");
        stack.print();
    }
}
