/* author: Jack Farah
 * description: Bucket sort implementation using merge sort collections to sort the array. O(n+k)
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int [] input = {54, 46, 83, 66, 95, 92, 43};  //Array to sort with a hashMap Bucket sort

        bucketSort(input);  // called the bucketSort function passing down the array

        for (int j : input) {
            System.out.println(j);
        }
    }

    /* type: Method
     * return type: none
     * parameters: int [] input
     * description: takes the array parameter, puts it into a hash table, and sorts the hash table using bucket sort
     *              algorithm.
     */
    public static void bucketSort(int[] input){
        List<Integer>[] buckets = new List[10];   //creates a list for buckets

        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<Integer>();  //placed a linked list for each bucket
        }

        for (int i = 0; i <input.length; i++) {
            buckets[hashCode(input[i])].add(input[i]);  //uses the hashCode method below to implement the hash for the buckets
        }                                               // loop ends when all the elements are placed into the hash table.

        for(List<Integer> bucket : buckets){            // uses merge sort to sort each bucket within itself.
            Collections.sort(bucket);
        }

        int j =0;

        for(int i =0; i <buckets.length; i++){         // retrieves elemenets in the bucket list and inputs it into the
            for(int value: buckets[i]){                // array, resulting in a sorted array.
                input[j++] = value;
            }
        }
    }

    /* type: method
     * return type: int
     * parameters: int value
     * description: a simple algorithm that calculates the hash for each element passed dowm. The Algorithm uses the 10th
     *              digit of the element to create its index.
     */
    public static int hashCode(int value){
        return value/((int)10);
    }
}
