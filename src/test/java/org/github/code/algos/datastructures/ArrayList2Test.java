package org.github.code.algos.datastructures;

import org.junit.jupiter.api.Test;

public class ArrayList2Test {

    @Test
    public void addTest(){
        ArrayList2<Integer> x  = new ArrayList2<>();

        x.add(23);
        x.add(26);
    }

    @Test
    public void add100Test(){

        ArrayList2<Integer> x  = new ArrayList2<>();

        for( int i=0; i<100 ; i++ ){
            x.add(i);
        }

        System.out.println("Size: "+ x.size());
    }

    @Test
    public void add1000Test(){

        ArrayList2<Integer> x  = new ArrayList2<>();

        for( int i=0; i<1000 ; i++ ){
            x.add(i);
        }

        System.out.println("Size: "+ x.size());

        for( int i=20; i< 400; i++  ){
            x.remove(i);
        }

        System.out.println("Size: "+ x.size());
    }


}
