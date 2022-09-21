package LinkedList;

public class Node {
    public Object data;
    public Node next;
    public Node prev;

//    public Node() {
//        this.data = null;
//        this.next = null;
//    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

//    public Node(Object data, Node next) {
//        this.data = data;
//        this.next = next;
//    }

    public String toString() {
        return String.valueOf(this.data);
    }
}
