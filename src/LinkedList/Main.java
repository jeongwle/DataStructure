package LinkedList;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.ListIterator;

@SuppressWarnings({"rawtypes", "unchecked", "ConstantConditions"})
public class Main {
    public static void main(String[] args) {
        LinkedList origin = new LinkedList();
        MyLinkedList mine = new MyLinkedList();

        methodTest(origin, mine);
        iteratorTest(origin, mine);
    }

    static void printBoth(LinkedList origin, MyLinkedList mine) {
        String msgOrigin = "\nOrigin\n Element : {0} \n Size : {1} \n";
        String msgMine = "Mine\n Element : {0} \n Size : {1} \n";

        String result = MessageFormat.format(msgOrigin, origin, origin.size());
        System.out.println(result);
        result = MessageFormat.format(msgMine, mine, mine.size());
        System.out.println(result);
        System.out.println("-----------------------------");
        System.out.println();
    }

    static void methodTest(LinkedList origin, MyLinkedList mine) {
        printBoth(origin, mine);
        addBoth(origin, mine);
        removeBoth(origin, mine);
        clearAndIsEmptyBoth(origin, mine);
        containsBoth(origin, mine);
        elementBoth(origin, mine);
        getBoth(origin, mine);
        indexOfBoth(origin, mine);
        lastIndexOfBoth(origin, mine);
        setBoth(origin, mine);
    }

    static void iteratorTest(LinkedList origin, MyLinkedList mine) {
        ListIterator oIt = origin.listIterator(0);
        ListIterator mIt = mine.myListIterator(0);

        System.out.println("mIt.hasPrevious() = " + mIt.hasPrevious());
        System.out.println("oIt.hasPrevious() = " + oIt.hasPrevious());
        System.out.println();

        System.out.println("mIt.hasNext() = " + mIt.hasNext());
        System.out.println("oIt.hasNext() = " + oIt.hasNext());
        System.out.println();

        while (mIt.hasNext()) {
            System.out.print("mIt.next() = " + mIt.next() + ", ");
            System.out.print("mIt.nextIndex() = " + mIt.nextIndex() + ", ");
            System.out.print("mIt.previousIndex() = " + mIt.previousIndex());
            System.out.println();
        }
        System.out.println();
        while (oIt.hasNext()) {
            System.out.print("oIt.next() = " + oIt.next() + ", ");
            System.out.print("oIt.nextIndex() = " + oIt.nextIndex() + ", ");
            System.out.print("oIt.previousIndex() = " + oIt.previousIndex());
            System.out.println();
        }
        printBoth(origin, mine);

        while (mIt.hasPrevious()) {
            System.out.print("mIt.previous() = " + mIt.previous() + ", ");
            System.out.print("mIt.nextIndex() = " + mIt.nextIndex() + ", ");
            System.out.print("mIt.previousIndex() = " + mIt.previousIndex());
            System.out.println();
        }
        System.out.println();
        while (oIt.hasPrevious()) {
            System.out.print("oIt.previous() = " + oIt.previous() + ", ");
            System.out.print("oIt.nextIndex() = " + oIt.nextIndex() + ", ");
            System.out.print("oIt.previousIndex() = " + oIt.previousIndex());
            System.out.println();
        }

        mIt = origin.listIterator(7);
        oIt = mine.myListIterator(7);

        while (mIt.hasPrevious() && oIt.hasPrevious()) {
            mIt.previous();
            oIt.previous();
            mIt.remove();
            oIt.remove();
            printBoth(origin, mine);
        }

        for (int i = 1; i < 5; i++) {
            mIt.add(i);
            oIt.add(i);
            printBoth(origin, mine);
        }

        while (mIt.hasPrevious() && oIt.hasPrevious()) {
            mIt.previous();
            oIt.previous();
            mIt.set(7);
            oIt.set(7);
            printBoth(origin, mine);
        }
    }

    static void setBoth(LinkedList origin, MyLinkedList mine) {
        System.out.println("Object set(int index, Object element)");
        System.out.println("origin.set(1, 10) = " + origin.set(1, 10));
        System.out.println("mine.set(1, 10) = " + mine.set(1, 10));
        printBoth(origin, mine);
    }

    static void lastIndexOfBoth(LinkedList origin, MyLinkedList mine) {
        System.out.println("int lastIndexOf(Object o)");
        for (int i = 1; i < 4; i++) {
            System.out.println("i = " + i);
            System.out.println("origin.lastIndexOf(i) = " + origin.lastIndexOf(i));
            System.out.println("mine.lastIndexOf(i) = " + mine.lastIndexOf(i));
            System.out.println();
        }
        printBoth(origin, mine);
    }

    static void indexOfBoth(LinkedList origin, MyLinkedList mine) {
        origin.add(2);
        origin.add(1);
        mine.add(2);
        mine.add(1);
        System.out.println("int indexOf(Object o)");
        for (int i = 1; i < 4; i++) {
            System.out.println("i = " + i);
            System.out.println("origin.indexOf(i) = " + origin.indexOf(i));
            System.out.println("mine.indexOf(i) = " + mine.indexOf(i));
            System.out.println();
        }
        printBoth(origin, mine);
    }

    static void getBoth(LinkedList origin, MyLinkedList mine) {
        System.out.println("Object get(int index)");
        System.out.println();
        for (int i = 1; i < 4; i++) {
            System.out.println("i = " + i);
            System.out.println("origin.get(i) = " + origin.get(i));
            System.out.println("mine.get(i) = " + mine.get(i));
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    static void elementBoth(LinkedList origin, MyLinkedList mine) {
        System.out.println("Object element()");
        System.out.println("origin.element() = " + origin.element());
        System.out.println("mine.element() = " + mine.element());
        printBoth(origin, mine);
    }

    static void containsBoth(LinkedList origin, MyLinkedList mine) {
        Object o = 3;
        System.out.println("boolean contains(Object o)");
        System.out.println("Object = " + o);
        boolean originRes = origin.contains(o);
        boolean mineRes = mine.contains(o);
        System.out.println("originRes = " + originRes);
        System.out.println("mineRes = " + mineRes);
        printBoth(origin, mine);
    }

    static void clearAndIsEmptyBoth(LinkedList origin, MyLinkedList mine) {
        System.out.println("void clear()");
        origin.clear();
        mine.clear();
        printBoth(origin, mine);

        System.out.println("boolean isEmpty()");
        System.out.println("origin.isEmpty() = " + origin.isEmpty());
        System.out.println("mine.isEmpty() = " + mine.isEmpty());
        System.out.println("\n-------------------------\n");

        for (int i = 1; i < 5; i++) {
            origin.add(i);
            mine.add(i);
        }
        origin.add(3);
        mine.add(3);
    }

    static void removeBoth(LinkedList origin, MyLinkedList mine) {
        switch (1) {
            case 1: {
                System.out.println("Object remove()");
                Object originRes = origin.remove();
                Object mineRes = mine.remove();
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);
            }
            case 2: {
                Object o = 4;
                System.out.println("boolean remove(Object o)");
                boolean originRes = origin.remove(o);
                boolean mineRes = mine.remove(o);
                System.out.println("Object = " + o);
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);

                o = "bye";
                originRes = origin.remove(o);
                mineRes = mine.remove(o);
                System.out.println("Object = " + o);
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);
            }
            case 3: {
                System.out.println("Object remove(int index)");
                Object originRes = origin.remove(1);
                Object mineRes = mine.remove(1);
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);
            }
            case 4: {
                System.out.println("Object removeFirst()");
                Object originRes = origin.removeFirst();
                Object mineRes = mine.removeFirst();
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);
            }
            case 5: {
                System.out.println("Object removeLast()");
                Object originRes = origin.removeLast();
                Object mineRes = mine.removeLast();
                System.out.println("originRes = " + originRes);
                System.out.println("mineRes = " + mineRes);
                printBoth(origin, mine);
            }
        }
    }

    static void addBoth(LinkedList origin, MyLinkedList mine) {
        switch (1) {
            case 1: {
                Object o = 1;
                System.out.println("boolean add(Object o)");
                boolean originResult = origin.add(o);
                boolean mineResult = mine.add(o);
                System.out.println("originResult = " + originResult);
                System.out.println("mineResult = " + mineResult);
                printBoth(origin, mine);
            }
            case 2: {
                Object o = "hello";
                System.out.println("void add(int index, Object o)");
                origin.add(1, o);
                mine.add(1, o);
                printBoth(origin, mine);
            }
            case 3: {
                Object o = true;
                System.out.println("void addFirst(Object o)");
                origin.addFirst(o);
                mine.addFirst(o);
                printBoth(origin, mine);
            }
            case 4: {
                Object o = "bye";
                System.out.println("void addLast(Object o)");
                origin.addLast(o);
                mine.addLast(o);
                printBoth(origin, mine);
            }
            default: {
                origin.add(1);
                origin.add(2);
                origin.add(3);
                origin.add(2);
                mine.add(1);
                mine.add(2);
                mine.add(3);
                mine.add(2);
                printBoth(origin, mine);
            }
        }
    }
}
