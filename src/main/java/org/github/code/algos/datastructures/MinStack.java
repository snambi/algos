package org.github.code.algos.datastructures;

public class MinStack {

    public static class Node{
        int value;
        Node next;
    }

    Node top = null;
    Node min = null;

    public MinStack() {
    }

    public void push(int val) {
        if( top == null ){
            top = new Node();;
            min = new Node();

            top.value = val;
            min.value = val;
        }else{
            Node x = new Node();
            x.value = val;
            x.next = top;

            top = x;

            if( top.value < min.value){
                Node y = new Node();
                y.value = top.value;
                y.next = min;
                min = y;
            }
        }
    }

    public void pop() {
        if( top != null ){

            if( top.value == min.value ){
                Node p1 = min.next;
                min = p1;
            }

            Node x1 = top.next;
            top = x1;

        }
    }

    public int top() {
        int v = -1;
        if( top != null ){
            v= top.value;
        }else{
            throw new IllegalStateException();
        }
        return v;
    }

    public int getMin() {
        return min.value;
    }

    public static void main(String[] args ){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top()); // return -3
        minStack.push(0);
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top()); // return -3
        minStack.push(-3);
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top()); // return -3
        minStack.pop();
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top());
        minStack.top();    // return 0
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top()); // return -2
        minStack.pop();
        System.out.println( "min: "+ minStack.getMin() + ", top: "+ minStack.top());
    }
}
