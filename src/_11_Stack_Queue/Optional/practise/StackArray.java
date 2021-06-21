package _11_Stack_Queue.Optional.practise;

public class StackArray {
    private int size;
    private int index=0;
    private int[] arr;

    public StackArray(int size){
        this.size = size;
        arr = new int[size];
    }
    public int size() {
        return index;
    }
    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }
    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }
    public void push(int data){
        if(isFull()){
            throw new StackOverflowError(" Stack is full data ");

        }
        arr[index]=data;
        index++;
    }
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        index--;
        return arr[index];
    }


}
