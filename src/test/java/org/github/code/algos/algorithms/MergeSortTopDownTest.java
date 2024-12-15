package org.github.code.algos.algorithms;

import org.junit.jupiter.api.Test;

import static org.github.code.algos.algorithms.MergeSortTopDown.sort;

public class MergeSortTopDownTest {

    @Test
    public void test_4digits(){
        int[] input = {67, 35, 23, 99};
        sort(input);
    }

    @Test
    public void test_5digits(){
        int[] input = {67, 35, 0, 23, 99};
        sort(input);
    }
}
