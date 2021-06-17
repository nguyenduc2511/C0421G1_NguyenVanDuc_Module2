package _10_DSA_List.practise.thuc_hanh_2;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList myListTest = new MyLinkedList();
        myListTest.addFirst(11);
        myListTest.addFirst(12);
        myListTest.addFirst(13);
        myListTest.add(4,9);
        myListTest.add(5,9);
        myListTest.printList();

        MyLinkedList myLinkedList2 = new MyLinkedList(100);
        myLinkedList2.add(2,5);
        myLinkedList2.addFirst(10);
        myLinkedList2.printList();
//        System.out.println(myLinkedList2.get(2));
    }
}
