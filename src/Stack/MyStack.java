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

        return -1;
    }

    private void removeElement() {
        Node<E> topPrev = findTopPrevNode();
        topPrev.next = null;
        size--;
    }

    private Node<E> findTopPrevNode() {
        Node<E> curr = bottom;
        for (int i = 0; i < size - 1; i++) {
            curr = curr.next;
        }
        return curr;
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
