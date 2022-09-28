package LinkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList {
    /*
    head : 첫 번째 노드
    tail : 마지막 노드
    size : 링크드리스트의 사이즈
     */
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /*
    add(Object input) : addLast()와 동일하게 동작한다.
    add(int index, Object input) : 지정한 index 에 새로운 노드 추가.
    addFirst(Object input) : 새로운 노드를 맨 첫번째에 추가.
    addLast(Object input) : 새로운 노드를 맨 마지막에 추가.
     */
    public void addFirst(Object input) {
        Node newNode = newNode(input);
        if (size() == 0) {
            firstAddChore(newNode);
            return;
        }
        linkNode(newNode, head);
        head = newNode;
        size++;

    }

    public void addLast(Object input) {
        Node newNode = newNode(input);
        if (size() == 0) {
            firstAddChore(newNode);
            return;
        }
        linkNode(tail, newNode);
        tail = newNode;
        size++;
    }

    public void add(int index, Object input) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(input);
            return;
        }
        if (index == size) {
            addLast(input);
            return;
        }
        Node newNode = newNode(input);
        Node prev = findNode(index - 1);
        Node curr = findNode(index);
        linkNode(prev, newNode);
        linkNode(newNode, curr);
        size++;
    }

    public boolean add(Object input) {
        addLast(input);
        return true;
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

    public boolean remove(Object o) {
        int index = findIndex(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public Object remove(int index) {
        checkIndex(index, size);
        Node target = findNode(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        linkNode(target.prev, target.next);
        size--;
        return target.data;
    }

    public Object removeFirst() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(head.next);
    }

    public Object removeLast() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        return unlinkLast(tail.prev);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object o) {
        int index = findIndex(o);
        return index != -1;
    }

    public Object element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public Object get(int index) {
        checkIndex(index, size);
        Node result = findNode(index);
        return result.data;
    }

    public int indexOf(Object o) {
        return findIndex(o);
    }

    public int lastIndexOf(Object o) {
        return findLastIndex(o);
    }

    public Object set(int index, Object element) {
        checkIndex(index, size);
        Node old = findNode(index);
        Object temp = old.data;
        old.data = element;
        return temp;
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass() || this.size != ((MyLinkedList) o).size()) {
            return false;
        }
        Node my = head;
        Node target = ((MyLinkedList) o).head;
        while (my != null) {
            if (!(my.equals(target.data))) {
                return false;
            }
            my = my.next;
            target = target.next;
        }
        return true;
    }

    public int hashCode() {
        int result = 1;
        Node curr = head;
        while (curr != null) {
            result = 31 * result + Objects.hash(curr);
            curr = curr.next;
        }

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(temp.data)
                    .append(", ");
            temp = temp.next;
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return String.valueOf(sb);
    }

    public ListIterator myListIterator(int index) {
        checkIndex(index, size);
        return new MyListIterator(index);
    }

    private class MyListIterator implements ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        MyListIterator(int index) {
            next = findNode(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = next = (next == null) ? tail : next.prev;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node lastNext = lastReturned.next;
            int index = findIndex(lastReturned);
            MyLinkedList.this.remove(index);
            if (next == lastReturned) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
        }

        @Override
        public void set(Object o) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.data = o;
        }

        @Override
        public void add(Object o) {
            lastReturned = null;
            MyLinkedList.this.add(o);
            nextIndex++;
        }
    }

    private Node findNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private int findIndex(Object target) {
        Node temp = head;
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (temp.equals(target)) {
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }

    private int findLastIndex(Object target) {
        Node temp = head;
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (temp.equals(target)) {
                index = i;
            }
            temp = temp.next;
        }
        return index;
    }

    private void linkNode(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
    }

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

    private Node newNode(Object o) {
        return new Node(o);
    }

    private void firstAddChore(Node newNode) {
        head = newNode;
        tail = newNode;
        size++;
    }

    private void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
