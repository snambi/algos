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

                System.out.println("before split: left: " + left + ", middle: " + middle + ", right: " + right + ", array: "+ printArray(arr));

                mergeSort(arr, 0, middle);
                mergeSort(arr, middle + 1, right);


                System.out.println("before merge: "+ printArray(arr));
                merge(arr, left, right, middle);

                System.out.println("after merge: "+ printArray(arr));
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

    public static void merge(final int[] arr, final int left, final int right, final int middle) {

        int count = 0;
        int total = right - left +1 ;
        int[] sorted = new int[total];

        int leftcount = middle-left + 1;
        int rightcount = right-middle;

        int[] leftarray = new int[leftcount];
        int[] rightarray = new int[rightcount];

        System.arraycopy(arr, left, leftarray, 0, leftcount);
        System.arraycopy(arr, middle+1, rightarray, 0, rightcount);

        int n = 0;
        int m = 0;

        System.out.println( "left: " + printArray(leftarray) + ", right: "+ printArray(rightarray));

        while( ( n < leftcount ) && ( m < rightcount ) ){

           if( leftarray[n] <= rightarray[m] ){
                sorted[count] = leftarray[n];
                n++;
           }else{
               sorted[count] = rightarray[m];
                m++;
            }

            count++;
        }

        // copy the remaining elements
        while( n < leftcount ){
            sorted[count] = leftarray[n];
            count++;
            n++;
        }

        while( m < rightcount ){
            sorted[count] = rightarray[m];
            count++;
            m++;
        }

        System.out.println( "result: " + printArray(sorted));

        // copy the sorted values into the original array
        int i=0;
        while( i < sorted.length ){
            int x = sorted[i];
            arr[left+i] = x;
            i++;
        }
    }

    public static void main(String[] args){

        int[] input = {67, 35, 23, 99};

        sort(input);

        sort(new int[]{6,78,4,99,3,26,1,0});
    }
}

