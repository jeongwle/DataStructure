package Stack;


import java.util.EmptyStackException;

public class MyStack<E> {
    private int size = 0;
    private Node<E> top;
    private Node<E> bottom;

    public MyStack() {
        top = null;
        bottom = null;
    }

    public E push(E item) {
        if (size == 0) {
            top = bottom = new Node<>(item);
            size++;
            return item;
        }
        Node<E> newNode = newNode(item);
        top.next = newNode;
        top = newNode;
        size++;
        return item;
    }

    public E pop() {
        E obj;
        obj = peek();
        removeElement();
        return obj;
    }

    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    public boolean empty() {
        return size == 0;
    }

    public int search(Object o) {
        int i = findLast(o);

        if (i >= 0) {
            return size - i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> temp = bottom;
        while (temp != null) {
            sb.append(temp.item)
                    .append(", ");
            temp = temp.next;
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return String.valueOf(sb);
    }

    private void removeElement() {
        Node<E> topPrev = findTopPrevNode();
        if (topPrev == null) {
            bottom = top = null;
            size--;
            return;
        }
        topPrev.next = null;
        top = topPrev;
        size--;
    }

    private Node<E> findTopPrevNode() {
        if (size == 1) {
            return null;
        }
        Node<E> curr = bottom;
        for (int i = 0; i < size - 2; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private int findLast(Object o) {
        Node<E> curr = bottom;
        int temp = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(curr.item)) {
                temp = i;
            }
            curr = curr.next;
        }
        return temp;
    }

    private Node<E> newNode(E item) {
        return new Node<>(item);
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
            next = null;
        }
    }
}
