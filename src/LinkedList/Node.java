package LinkedList;

import java.util.Objects;

public class Node {
    public Object data;
    public Node next;
    public Node prev;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || data.getClass() != o.getClass()) {
            return false;
        }
        return data.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}
