package Queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> origin = new LinkedList<>();
        MyQueue<Integer> mine = new MyQueue<>();

        test(origin, mine);
    }

    public static void printQueue(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("origin = " + origin);
        System.out.println("origin.size() = " + origin.size());
        System.out.println("mine = " + mine);
        System.out.println("mine.size() = " + mine.size());
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println();
    }

    public static void test(Queue<Integer> origin, MyQueue<Integer> mine) {
        printQueue(origin, mine);
        add(origin, mine);
        remove(origin, mine);
        noSuchElement(origin, mine);
        offer(origin, mine);
        poll(origin, mine);
        peek(origin, mine);
    }

    public static void add(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("boolean add(E e)");
        System.out.println();
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                origin.add(i);
                mine.add(i);
            }
        }
        printQueue(origin, mine);
    }

    public static void remove(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("E remove()");
        System.out.println();
        int size = origin.size();
        for (int i = 0; i < size; i++) {
            Integer o = origin.remove();
            Integer m = mine.remove();
            System.out.println("origin.remove() = " + o);
            System.out.println("mine.remove() = " + m);
        }
        printQueue(origin, mine);
    }

    public static void noSuchElement(Queue<Integer> origin, MyQueue<Integer> mine) {
        try {
            origin.element();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            mine.element();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void offer(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("boolean offer(E e)");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            origin.offer(i);
            mine.offer(i);
        }
        printQueue(origin, mine);
    }

    public static void poll(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("E poll()");
        System.out.println();
        for (int i = 0; i < 6; i++) {
            Integer o = origin.poll();
            Integer m = mine.poll();
            System.out.println("origin.poll() = " + o);
            System.out.println("mine.poll() = " + m);
        }
        printQueue(origin, mine);
    }

    public static void peek(Queue<Integer> origin, MyQueue<Integer> mine) {
        System.out.println("E peek()");
        System.out.println();
        System.out.println("origin.peek() = " + origin.peek());
        System.out.println("mine.peek() = " + mine.peek());
        System.out.println();
        System.out.println("after add 1, 2");
        System.out.println();

        for (int i = 0; i < 2; i++) {
            origin.add(i + 1);
            mine.add(i + 1);
        }
        System.out.println("origin.peek() = " + origin.peek());
        System.out.println("mine.peek() = " + mine.peek());
        System.out.println();
        System.out.println("origin.element() = " + origin.element());
        System.out.println("mine.element() = " + mine.element());
        System.out.println();
        printQueue(origin, mine);
    }

}
