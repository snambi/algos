package org.github.code.algos.datastructures;

public class ArrayList2<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private T[] elements;

    public ArrayList2(){
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add( T t){
        ensureCapacity();
        elements[size] = t;
        size++;
    }

    public T remove(int index){
        checkSize(index);

        T removed = elements[index];

        // move the elements
        for( int n=index; n< (size-1); n++ ){
            elements[n] = elements[n+1];
        }

        size--;

        ensureCapacity();

        return removed;
    }

    public int size(){
        return this.size;
    }

    public T get( int i){
        checkSize(i);
        return elements[i];
    }

    private void ensureCapacity(){

        // increase size
        if( size == elements.length ){
            // increase the size of array
            T[] newarray = (T[]) new Object[size*2];
            System.arraycopy(elements, 0, newarray, 0, size);
            this.elements = newarray;
            System.out.println("Capacity increased to "+ this.elements.length );
        }

        // reduce size
        if( (size * 2 )  < (elements.length) && ( size > DEFAULT_CAPACITY)){
            T[] newarray = (T[]) new Object[size*2];
            System.arraycopy(elements, 0, newarray, 0, size);
            this.elements = newarray;
            System.out.println("Capacity reduced to "+ this.elements.length );
        }
    }

    private void checkSize(int i ){
        if( i < 0 || i >= size ){
            throw new IndexOutOfBoundsException();
        }
    }



}
