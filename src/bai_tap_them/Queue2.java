package bai_tap_them;

public class Queue2<E> {
     class Node{
        public Object data;
        public Node next;
        public Node(Object data) {
            this.data = data;
        }
    }
    private Node front;
    private Node rear;

    public Queue2() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue (E element){
        Node tepm = new Node(element);
        if (this.front == null){
            this.front = this.rear = tepm;
        } else {
            this.rear.next = tepm;
            this.rear = tepm;
            this.rear.next = this.front;
        }
    }
    public void deQueue(){
        if (this.front == null){
            return ;
        }
        if (this.front == this.rear){
            this.front = this.rear = null;
        } else {
            this.front = this.front.next;
            this.rear.next = this.front;
        }
    }

    public void display() {
        Node temp = this.front;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (!(temp == front));
    }

    public static void main(String[] args) {
        Queue2<Integer> myQuene = new Queue2<>();
        myQuene.enQueue(9);
        myQuene.enQueue(8);
        myQuene.enQueue(7);
        myQuene.enQueue(6);
        myQuene.enQueue(5);
        System.out.println("Trước khi deQueue");
        myQuene.display();

        myQuene.deQueue();
        myQuene.deQueue();
        System.out.println("SAu khi deQueue");
        myQuene.display();

    }
}
