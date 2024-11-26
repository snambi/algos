package org.github.code.algos.algorithms;

public class MergeSortTopDown {

    public static void sort(int[] arr) {
        mergeSort( arr, 0, arr.length-1);
    }

    public static void mergeSort( int[] arr, int left, int right){

        if( left < right ){

            int middle = ( right - left ) / 2;

            if( left == (right -1 )){
                // swap
                if( arr[left] > arr[right] ) {
                    int temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                }
            }else {

                System.out.println("before: "+ printArray(arr));

                mergeSort(arr, 0, middle);
                mergeSort(arr, middle + 1, right);


                System.out.println("middle: "+ printArray(arr));
                merge(arr, left, right, middle);

                System.out.println("after: "+ printArray(arr));
            }
        }
    }



    public static String printArray(int[] arr ){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for( int i=0; i<arr.length ; i++ ){
            sb.append(arr[i]);
            sb.append(",");
        }
        sb.append(" ]");

        return sb.toString();
    }

    public static void merge(int[] arr, int left, int right, int middle) {

        int[] result = new int[right-left];
        int count = 0;
        int total = right - left;

        int innerLoopPosition = middle +1;
        for( int i=left; i <=middle; i++){
            int x = arr[i];
            for( int j=innerLoopPosition ; j<=right ; j++ ){

                if( x <= arr[j]){
                    // copy the left value to result
                    result[count] = x;
                    count++;
//                    result[count] = arr[j];
//                    count++;
//                    innerLoopPosition++;
                    break;
                }

                if( x > arr[j]){
                    // copy the right value to result
                    result[count] = arr[j];
                    count++;
                    innerLoopPosition++;
                    // no break
                }
            }
        }

        System.out.println( "result: " + printArray(result));
    }

    public static void main(String[] args){

        int[] input = {67, 35, 23, 99};

        sort(input);
    }
}

