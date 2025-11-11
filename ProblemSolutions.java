/******************************************************************
 *
 *   Mahran Alkhalil / COMP400C MWF 11:30-12:20
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE

        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        //  create a set of all list1 elements
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list1.length; i++) {
            set.add(list1[i]);
        }
        // loop through list 2 elements and check if they ALL are in the set, otherwise it is not a subset
        for (int i = 0; i < list2.length; i++) {
            if (!set.contains(list2[i])) {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE


        if (array == null || k < 1 || k > array.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Min-heap to keep track of top K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : array) {
            minHeap.add(num);

            // Keep heap size at most K
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        // using hash set can be faster for insertion but will remove elements if they exist in both arrays
    
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : array1){
            pq.add(num);
        } 

        for (int num : array2){
            pq.add(num);
        } 

        int[] result = new int[array1.length + array2.length];
    
        int i = 0;
        while (!pq.isEmpty()){
            result[i++] = pq.poll();
        } 
        
        
        return result;
    }

}