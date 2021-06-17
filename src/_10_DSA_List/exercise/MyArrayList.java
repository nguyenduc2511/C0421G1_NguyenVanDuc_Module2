package _10_DSA_List.exercise;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("the specified initial capacity is negative");
        } else {
            elements = new Object[capacity];
        }
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = elements.length - 1; i >= index; i--) {
            if (elements[i] != null) {
                elements[i + 1] = elements[i];
            }
        }
        elements[index] = e;
        size++;
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public int size() {
        return size;
    }

    public void forEach() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                System.out.println("vi tri " + i + " co gia tri " + elements[i]);
            }
        }

    }

    public E remove(int index) {
        for(int i =0;i<elements.length;i++) {
            if(i==index){
                elements[i] = null;
                for (int j = i; j < elements.length - 1; j++) {
                    elements[j] = elements[j + 1];
                    elements[j + 1] = null;
                }
            }
        }
        return (E) elements;
    }
    public int indexOf(E element){
        for (byte i=0; i< this.elements.length; i++){
            if (this.elements[i] == element){
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E element){

        return indexOf(element) >=0;
    }
    public void clear(){
        for (int i=0; i < elements.length; i++){
            elements[i] = null;
        }
        this.size =0;
    }
}

