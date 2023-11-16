package SortAndSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab 06 Implementing Sorting and Searching Algorithms
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class SortAndSearch {
    /**
     * The main method to start test.
     * 
     * @param args A reference to an command-line arguments
     * @throws FileNotFoundException "items.txt" is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] list = new String[9];

        create(list);
        System.out.println("The string list: ");
        display(list);

        quickSort(list, 0, list.length - 1);
        System.out.println("The list sorted using quick sort: ");
        display(list);

        create(list);
        System.out.println("The list sorted using merge sort: ");
        mergeSort(list, 0, list.length - 1);
        display(list);

        System.out.println("The index of \"Logan\" in the list(binary search): " + binarySearch(list, "Logan"));
        System.out.println("The index of \"Apple\" in the list(sequential search): " + sequentialSearch(list, "Apple"));
        System.out.println("(If the index is -1, then the element is not in the list.)");
    }

    /**
     * Creates the list by reading a input file.
     * 
     * @param list The strings list
     */
    public static void create(String[] list) throws FileNotFoundException {
        Scanner input = new Scanner(new File("items.txt"));
        int i = 0;
        while (input.hasNextLine()) {
            list[i] = input.nextLine();
            i++;
        }
    }

    /**
     * Displays the list
     * 
     * @param list The strings list
     */
    public static void display(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i < list.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Sorts the list by the quick sort algorithm.
     * 
     * @param list  The strings list to be sorted.
     * @param left  The left index of the array to be sorted.
     * @param right The right index of the array to be sorted.
     */
    public static void quickSort(String[] list, int left, int right) {
        // Base case: No elements to sorted.
        if (left >= right) {
            return;
        }

        // The leftmost element of the barray is the pivot.
        // The left pointer and the right pointer.
        int i = left, j = right;
        while (i < j) {
            // Find an element smaller than the pivot on the right side.
            while (i < j && list[j].compareTo(list[left]) >= 0) {
                j--;
            }
            // Find an element larger than the pivot on the left side.
            while (i < j && list[i].compareTo(list[left]) <= 0) {
                i++;
            }

            // Swap the elements at positions i and j if i is less than j.
            if (i < j) {
                String temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        // Swap the pivot (at position left) with the element at position i.
        String temp = list[i];
        list[i] = list[left];
        list[left] = temp;

        // Recursively sort the subarrays to the left and right of the pivot.
        quickSort(list, left, i - 1);
        quickSort(list, i + 1, right);
    }

    /**
     * Sorts the list again by the merge sort algorithm.
     * 
     * @param list  The strings list
     * @param left  The left index of the array to be sorted.
     * @param right The right index of the array to be sorted.
     */
    public static void mergeSort(String[] list, int left, int right) {
        // Terminates recursion when subarray length is 1.
        if (left >= right) {
            return;
        }
        // Divides the array into two sub arrays from the midpoint.
        // Calculates midpoint.
        int mid = (left + right) / 2;
        // Divides the left array.
        mergeSort(list, left, mid);
        // Divides the right array.
        mergeSort(list, mid + 1, right);

        // Merges the left and right subarrays into an ordered array from bottom to top.
        // A temp array
        String[] temp = new String[right - left + 1];
        // Traverse indexes of left and right arrays and temp array.
        int i = left, j = mid + 1, k = 0;
        // When there are still elements in both the left and right arrays,
        // compares and copies the smaller elements into the temp array.
        while (i <= mid && j <= right) {
            if (list[i].compareTo(list[j]) <= 0)
                temp[k++] = list[i++];
            else
                temp[k++] = list[j++];
        }
        // Copies the remaining elements of the left and right arrays
        // into the temp array.
        while (i <= mid) {
            temp[k++] = list[i++];
        }
        while (j <= right) {
            temp[k++] = list[j++];
        }
        // Copies the array "temp" back to the original array "list".
        for (k = 0; k < temp.length; k++) {
            list[left + k] = temp[k];
        }
    }

    /**
     * In the sorted list, search “Logan” using the binary search algorithm.
     * 
     * @param list   The sorted strings list
     * @param target The string to search
     * @return The index of the string in the list
     */
    public static int binarySearch(String[] list, String target) {
        // The search range.
        int low = 0, high = list.length - 1;
        // Continue searching until low > high
        while (low <= high) {
            // Calculate the middle index of the current search range.
            int middle = (low + high) / 2;
            // Compare the target string with the middle element of the current range.
            int compareResult = target.compareTo(list[middle]);
            if (compareResult == 0) {
                // The target is found; returns its index.
                return middle;
            } else if (compareResult < 0) {
                // Adjusts the high index to search the left half.
                high = middle - 1;
            } else {
                // Adjusts the low index to search the right half.
                low = middle + 1;
            }
        }
        // The target is not found.
        return -1;
    }

    /**
     * In the sorted list, search an element using the sequential search algorithm.
     * 
     * @param list   The sorted strings list
     * @param string The string to search
     * @return The index of the string in the list
     */
    public static int sequentialSearch(String[] list, String target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        // The target is not found.
        return -1;
    }
}