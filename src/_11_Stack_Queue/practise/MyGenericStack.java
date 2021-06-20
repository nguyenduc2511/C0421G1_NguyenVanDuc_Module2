package _11_Stack_Queue.practise;


import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {

        stack = new LinkedList<>();
    }

    public int size(){

        return stack.size();
    }

    public boolean isEmpty(){
        if (size() ==0){
            return true;
        }
        return false;
    }

    public void push(T element){

        stack.addFirst(element);
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        } else {
            return stack.removeFirst();
        }

    }
}
