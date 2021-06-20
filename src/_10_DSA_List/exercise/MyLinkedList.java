package _10_DSA_List.exercise;

public class MyLinkedList<E> {

    private class Nodes {
        public Nodes next;
        public Object data;

        public Nodes(Object data) {

            this.data = data;
        }

        public Object getData() {

            return data;
        }
    }

    private Nodes head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void addFirst(E element) {
        Nodes temp = head;
        head = new Nodes(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Nodes temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Nodes(element);
        numNodes++;
    }

    public void addIndex(int index, E element) {
        Nodes temp = head;
        Nodes holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Nodes(element);
        temp.next.next = holder;
        numNodes++;
    }

    public E get(int index) {
        Nodes temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp;
    }

    public int size() {

        return numNodes;
    }

    public E remove(int index) {
        if (index >= 0 && index <= numNodes) {
            Nodes temp = head;
            Object data;
            if (index == 0) {
                data = temp.data;
                head = head.next;
            } else {
                for (int i = 0; i < index - 1 && temp.next != null; i++) {
                    temp = temp.next;
                }
                data = temp.next.data;
                temp.next = temp.next.next;
            }
            numNodes--;
            return (E) data;
        } else {
            throw new IllegalArgumentException("Exception index" + index);
        }
    }

    public boolean remove(E element) {
        Nodes temp = head;
        if (temp.data.equals(element)) {
            remove(0);
            return true;
        } else {
            for (int i = 0; i < numNodes; i++) {
                if (temp.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
     public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Nodes temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    
}
