package org.github.code.algos.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class BinaryTree2Test {

    @Test
    public void addTest(){
        BinaryTree2 dd = new BinaryTree2();

        Random rand = new Random();
        dd.add(999);
        for( int i=0; i< 20 ; i++ ){
            int x = rand.nextInt(1000);
            dd.add(x);
        }

        System.out.println("Root "+ dd.getRoot().getValue());
        dd.inOrderTraversal();

    }
}
