package Queue;

import LinkedList.MyLinkedList;

import java.util.NoSuchElementException;

public class MyQueue<E> extends MyLinkedList<E> implements QueueInterface<E> {

    public MyQueue() {
        super();
    }
    @Override

    public boolean add(E e) {
        checkSize();
        return super.add(e);
    }

    @Override
    public E remove() {
        checkEmpty();
        return super.removeFirst();
    }

    @Override
    public E element() {
        checkEmpty();
        return super.get(0);
    }

    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    @Override
    public E poll() {
        if (super.isEmpty()) {
            return null;
        }
        return super.removeFirst();
    }

    @Override
    public E peek() {
        if (super.isEmpty()) {
            return null;
        }
        return super.get(0);
    }

    private void checkSize() {
        if (size == Integer.MAX_VALUE) {
            throw new IllegalStateException();
        }
    }

    private void checkEmpty() {
        if (super.isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}
