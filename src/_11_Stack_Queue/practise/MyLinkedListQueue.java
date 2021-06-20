package _11_Stack_Queue.practise;

public class MyLinkedListQueue<E> {

     class Node<E> {
        public E value;
        public Node next;
        public String key;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(Object param) {
        Node tepm = new Node(param);
        if (this.tail == null) {
            this.head = this.tail = tepm;
            return;
        }
        this.tail.next = tepm;
        this.tail = tepm;
    }

    public Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }
}
