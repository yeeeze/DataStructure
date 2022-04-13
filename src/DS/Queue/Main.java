package DS.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();

//        queue.remove();
        queue.add("apple"); queue.print();
        queue.add("orange");    queue.print();
        queue.add("cherry");    queue.print();
        queue.add("pear");  queue.print();

        queue.remove(); queue.print();

        queue.add("grape"); queue.print();

        queue.remove(); queue.print();

        queue.add("lemon"); queue.print();
        queue.add("mango"); queue.print();
        queue.add("lime");  queue.print();
        queue.add("kiwi");  queue.print();

        queue.remove(); queue.print();
    }
}
