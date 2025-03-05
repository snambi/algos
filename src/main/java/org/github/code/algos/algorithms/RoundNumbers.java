package org.github.code.algos.algorithms;

public class RoundNumbers {
    public static void main(String[] args) {
        double value1 = 3.4256;
        double value2 = 3.4212;

        System.out.println( value1 * 100.0 + ", " + Math.round(value1 * 100.0));
        System.out.println( value2 * 100.0 + ", " + Math.round(value2 * 100.0));
        double rounded1 = Math.round(value1 * 100.0) / 100.0;
        double rounded2 = Math.round(value2 * 100.0) / 100.0;

        System.out.println(rounded1); // Output: 3.43
        System.out.println(rounded2); // Output: 3.42
    }
}
