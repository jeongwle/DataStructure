package Stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> origin = new Stack<>();
        MyStack<Integer> mine = new MyStack<>();

        test(origin, mine);
    }

    public static void test(Stack<Integer> origin, MyStack<Integer> mine) {
        printStack(origin, mine);
        push(origin, mine);
        pop(origin, mine);
        empty(origin, mine);
        search(origin, mine);
        peek(origin, mine);
    }

    public static void printStack(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("origin = " + origin);
        System.out.println("origin.size() = " + origin.size());
        System.out.println("mine = " + mine);
        System.out.println("mine.size() = " + mine.size());
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println();
    }

    public static void peek(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("E peek()");
        System.out.println();
        System.out.println("origin = " + origin);
        System.out.println("origin.size() = " + origin.size());
        System.out.println("mine = " + mine);
        System.out.println("mine.size() = " + mine.size());
        System.out.println();

        Integer o = origin.peek();
        Integer m = mine.peek();
        System.out.println("origin.peek() = " + o);
        System.out.println("mine.peek() = " + m);
        System.out.println();
        printStack(origin, mine);
    }
    public static void push(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("E push()");
        for (int i = 0; i < 11; i++) {
            if (i % 2 == 0) {
                Integer o;
                Integer m;
                o = origin.push(i);
                m = mine.push(i);
                System.out.println("origin = " + o);
                System.out.println("mine = " + m);
            }
        }
        printStack(origin, mine);
    }

    public static void pop(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("E pop()");
        for (int i = 0; i < 6; i++) {
            Integer o;
            Integer m;
            o = origin.pop();
            m = mine.pop();
            System.out.println("origin = " + o);
            System.out.println("mine = " + m);
        }
        printStack(origin, mine);
    }

    public static void empty(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("boolean empty()");
        System.out.println("origin.empty() = " + origin.empty());
        System.out.println("mine.empty( = " + mine.empty());
        System.out.println();
        System.out.println("---------------------------------");
    }

    public static void search(Stack<Integer> origin, MyStack<Integer> mine) {
        System.out.println("int search(int index)");
        origin.push(0);
        origin.push(2);
        origin.push(4);
        origin.push(2);
        origin.push(0);
        mine.push(0);
        mine.push(2);
        mine.push(4);
        mine.push(2);
        mine.push(0);

        System.out.println();
        System.out.println("origin.search(0) = " + origin.search(0));
        System.out.println("origin.search(2) = " + origin.search(2));
        System.out.println("origin.search(4) = " + origin.search(4));
        System.out.println("mine.search(0) = " + mine.search(0));
        System.out.println("mine.search(2) = " + mine.search(2));
        System.out.println("mine.search(4) = " + mine.search(4));
        System.out.println();
        System.out.println("---------------------------------");

    }
}
