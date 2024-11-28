package org.github.code.algos.medium;

import java.util.Arrays;

/**

 Given an integer array nums, find the
 subarray
 with the largest sum, and return its sum.

 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 Example 2:

 Input: nums = [1]
 Output: 1
 Explanation: The subarray [1] has the largest sum 1.
 Example 3:

 Input: nums = [5,4,-1,7,8]
 Output: 23
 Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


 Constraints:

 1 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4

 */
public class MaxSubArray {

    public static void main(String[] args){

//        int[] input1 = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] output1 = getMaxArray(input1);
//
//        System.out.printf("Sum %d Array %s\n", sum(output1), Arrays.toString(output1 ));
//
//        int[] input2 = {1};
//        int[] output2 = getMaxArray(input2);
//        System.out.printf("Sum %d Array %s\n", sum(output2), Arrays.toString(output2 ));
//
//        int[] input3 = {5,4,-1,7,8};
//        int[] output3 = getMaxArray(input3);
//        System.out.printf("Sum %d Array %s\n", sum(output3), Arrays.toString(output3 ));

//        int[] input4 = {-2, -1};
//        int[] output4 = getMaxArray(input4);
//        System.out.printf("Sum %d Array %s\n", sum(output4), Arrays.toString(output4 ));

        int[] input5 = {-1, -2};
        int[] output5 = getMaxArray(input5);
        System.out.printf("Sum %d Array %s\n", sum(output5), Arrays.toString(output5 ));
    }


    public static int[] getMaxArray( int[] input ){

        int[] result = null;
        int sum = 0;
        boolean isInitialized = false;

        if( input.length == 1){
            result = input;
        }else{
            // outer loop determines the starting point
            for( int i=0; i< input.length ; i++ ){

                // inner loop determines the end-point
                for( int j=i ; j <= input.length ; j++ ){

                    int[] array = Arrays.copyOfRange(input, i, j);

                    int s = sum(array);

                    if ( array.length > 0 ) {
                        if( !isInitialized ){
                            sum = s;
                            result = array;
                            isInitialized = true;
                        }else {
                            if (s > sum) {
                                result = array;
                                sum = s;
                            }
                        }
                    }

                    //printArray(sum, array);
                }
            }
        }

        return result;
    }

    public static int sum( int[] array ){
        int sum = 0;

        if( array != null ) {
            for (int j : array) {
                sum = sum + j;
            }
        }

        return sum;
    }

    public static void printArray(int result , int[] array ){
        int sum = sum( array);

        System.out.print("Result: ");
        System.out.print(result);
        System.out.print(", Sum: ");
        System.out.print(sum);
        System.out.print(", {");

        for( int i : array ){
            System.out.print(i);
            System.out.print(",");
        }

        System.out.println("}");
    }
}
