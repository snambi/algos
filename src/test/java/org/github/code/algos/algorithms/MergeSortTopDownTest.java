package org.github.code.algos.algorithms;

import org.junit.jupiter.api.Test;


public class MergeSortTopDownTest {

    @Test
    public void test_4digits(){
        int[] input = {67, 35, 23, 99};

        System.out.println("Un Sorted: "+ MergeSortTopDown.printArray(input));
        MergeSortTopDown sorter = new MergeSortTopDown(false);
        sorter.sort(input);

        System.out.println("Sorted   : "+ MergeSortTopDown.printArray(input));
    }

    @Test
    public void test_5digits(){
        int[] input = {67, 35, 0, 23, 99};
        MergeSortTopDown sorter = new MergeSortTopDown(false);
        sorter.sort(input);
    }
}
