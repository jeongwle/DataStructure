package LinkedList;

import java.util.NoSuchElementException;

class Test {
    public static void main(String[] args) {
//        LinkedList test = new LinkedList();
//        System.out.println(test);
//        test.add(0, "hello");
//        test.add(1);
//        test.add(true);
//        test.add(1, "three");
//        test.add(1, "one");
//        test.add(100);
//
//
//        System.out.println(test);
////        test.set(1, "bello");
//
//        System.out.println(test);
//        test.add("add");
//        System.out.println(test);

//        LinkedList test2 = new LinkedList();
//        test2.add(0, "hello");
//        System.out.println(test2);
//        Object o = test2.removeFirst();
//        System.out.println("o = " + o);
//        test2.add("hello");
//        test2.add(true);
//        test2.add(1, "middle");
//        System.out.println(test2);
//        test2.removeFirst();
//        test2.removeFirst();
//        test2.add("hello world");
//        System.out.println(test2.size());
//        System.out.println(test2);

    }
}

public class LinkedList {
    private Node head;  // 첫 번째 노드를 가리키는 head 노드
    private Node tail;  // 마지막 노드
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /*
    add(Object input) : addLast와 동일하게 동작한다.
    add(int index, Object input) : 지정한 index에 새로운 노드 추가.
    addFirst(Object input) : 새로운 노드를 맨 첫번째에 추가.
    addLast(Object input) : 새로운 노드를 맨 마지막에 추가.
     */
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        if (size() == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        linkNode(newNode, head);
        head = newNode;
        size++;

    }
//    public void addFirst(Object input) {
//        Node newNode = new Node(input);
//        linkNode(newNode, head);
////        newNode.next = head;
////        head.prev = newNode;
//        head = newNode;
//        if (size == 0) {
//            tail = head;
//        }
//        size++;
//    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size() == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        linkNode(tail, newNode);
//        tail.next = newNode;
//        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int index, Object input) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + this.size());
        }
        if (index == 0) {
            addFirst(input);
            return;
        }
        if (index == this.size()) {
            addLast(input);
            return;
        }
        Node newNode = new Node(input);
        Node prev = findNode(index - 1);
        Node curr = findNode(index);
        linkNode(prev, newNode);
//        prev.next = newNode;
//        newNode.prev = prev;
        linkNode(newNode, curr);
//        newNode.next = curr;
//        curr.prev = newNode;
        size++;
    }

    public void add(Object input) {
        addLast(input);
    }
    /*
    remove() : 맨 첫번째 노드를 삭제
    remove(Object o) : o와 일치하는 데이터를 갖고 있는 노드 삭제
    remove(int index) : 인덱스에 해당하는 노드 삭제
    removeFirst : 맨 처음 노드를 삭제
    removeLast : 맨 마지막 노드를 삭제
     */

    public Object remove() {
        return removeFirst();
    }

    public Object remove(Object o) {
        Node target = findNode(o);
        return target.data;
    }

    public Object remove(int index) {
        Object target = findNode(index).data;
        return remove(target);
    }

    public Object removeFirst() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
//        Node temp = head;
//        head = head.next;
//        head.prev = null;
        return unlinkFirst(head.next);
    }

    public Object removeLast() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
//        Node temp = tail;
//        tail = tail.prev;
//        tail.next = null;
//        size--;
        return unlinkLast(tail.prev);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node findNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private Node findNode(Object target) {
        Node temp = head;
        Node resultTemp = null;
        for (int i = 0; i < size(); i++) {
            if (temp.data == target) {
                resultTemp = temp;
            }
            temp = temp.next;
        }
        return resultTemp;
    }

    private void linkNode(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
    }

//    private void unlinkNode(Node prev, Node next) {
//        prev.n
//    }

    private Object unlinkFirst(Node newHead) {
        Node temp = head;
        if (temp.equals(tail)) {
            head = null;
            tail = null;
            size--;
            return temp.data;
        }
        head = newHead;
        head.prev = null;
        size--;
        return temp.data;
    }

    private Object unlinkLast(Node newTail) {
        Node temp = tail;
        if (temp.equals(head)) {
            head = null;
            tail = null;
            size--;
            return temp.data;
        }
        tail = newTail;
        tail.next = null;
        size--;
        return temp.data;
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node temp = head;
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(temp.data)
                    .append(", ");
            temp = temp.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return String.valueOf(sb);
    }

}
