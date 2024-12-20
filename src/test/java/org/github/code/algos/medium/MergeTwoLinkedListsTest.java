package org.github.code.algos.medium;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MergeTwoLinkedListsTest {

    @Test
    public void test1(){

        MergeTwoLinkedLists.SinglyLinkedList llist1 = new MergeTwoLinkedLists.SinglyLinkedList();

        llist1.insertNode(4);
        llist1.insertNode(5);
        llist1.insertNode(6);

        MergeTwoLinkedLists.SinglyLinkedList llist2 = new MergeTwoLinkedLists.SinglyLinkedList();
        llist2.insertNode(1);
        llist2.insertNode(2);
        llist2.insertNode(10);


        MergeTwoLinkedLists.SinglyLinkedListNode result = MergeTwoLinkedLists.mergeLists(llist1.head, llist2.head);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            MergeTwoLinkedLists.printSinglyLinkedList(llist1.head, ",", bufferedWriter);
            MergeTwoLinkedLists.printSinglyLinkedList(llist2.head, ",", bufferedWriter);
            MergeTwoLinkedLists.printSinglyLinkedList(result, ",", bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test3(){

        MergeTwoLinkedLists.SinglyLinkedList llist1 = new MergeTwoLinkedLists.SinglyLinkedList();

        llist1.insertNode(1);
        llist1.insertNode(2);
        llist1.insertNode(3);

        MergeTwoLinkedLists.SinglyLinkedList llist2 = new MergeTwoLinkedLists.SinglyLinkedList();
        llist2.insertNode(3);
        llist2.insertNode(4);


        MergeTwoLinkedLists.SinglyLinkedListNode result = MergeTwoLinkedLists.mergeLists(llist1.head, llist2.head);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            MergeTwoLinkedLists.printSinglyLinkedList(llist1.head, ",", bufferedWriter);
            MergeTwoLinkedLists.printSinglyLinkedList(llist2.head, ",", bufferedWriter);
            MergeTwoLinkedLists.printSinglyLinkedList(result, ",", bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
