package org.github.code.algos.medium;

import java.io.*;
import java.util.*;

public class MergeTwoLinkedLists {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }

        bufferedWriter.write(String.valueOf("\n"));
        bufferedWriter.flush();
    }



    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {


        SinglyLinkedListNode result = null;

        if( head1 == null && head2 == null ){
            return result;
        }
        if(head1 != null && head2 == null){
            return head1;
        }
        if(head2 != null && head1 == null ){
            return head2;
        }

        // merge
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;

        SinglyLinkedListNode first = null;
        SinglyLinkedListNode tail = null;
        while( node1 != null || node2 != null ){
            int x=0;

            if( node1 != null && node2 != null ){
                if( node1.data <= node2.data ){
                    x = node1.data;
                    node1 = node1.next;
                }else{
                    x = node2.data;
                    node2 = node2.next;
                }
            }else if( node1 == null && node2 != null ) {
                x = node2.data;
                node2 = node2.next;
            }else if( node1 != null && node2 == null ){
                x = node1.data;
                node1 = node1.next;
            }

            System.err.println("x: "+ x);
            if(first == null){
                first = new SinglyLinkedListNode(x);
                tail = first;
            }else{
                tail.next = new SinglyLinkedListNode(x);
                tail = tail.next;
            }
        }

        return first;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
