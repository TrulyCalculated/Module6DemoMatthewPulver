import java.util.Scanner;
public class arrayPractice<arrayOfInts> {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] arrayInt = {4, 8, 1 ,4, 0, 1, 100, 1, 2, 4, 6, 2, 3, 5, 2, 5, 6, 8, 69};
        selectionSort(arrayInt);
        binarySearch(arrayInt, 69);
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime-startTime) + " ns.");

    }

    public static int linearSearch(int[] list, int key) {
        int index = -1;
        for (int i = 0; i < list.length && index == -1; i++) {
            if (list[i] == key) {
                index = i;
                System.out.println("The key was found. Nice.");
            }
        }
        if (index == -1){
            System.out.println("The key was not found.");
        }
        return index;
    }

    public static int binarySearch(int[] list, int key) {
        int start = 0, end = list.length - 1, mid;
        while (end >= start) {
            mid = (start + end) / 2;
            if (key < list[mid]) {
                end = mid - 1;
            } else if (key > list[mid]) {
                start = mid + 1;
            } else{
                System.out.println("The key " + key + " has been found.");
                return mid; //found
            }
        }
        System.out.println("The key " + key + " has not been found.");
        return -1; //not found
    }
    //DEVELOPER COMMENT: SHOULD HAVE USED BOGOSORT!
    public static void selectionSort(int[] list){
       int i, minIndex;
       for (i = 0; i < list.length; i++){
           minIndex = findMin(list, i, list.length);
           swapElements(list, i, minIndex);
       }
    }
    public static int findMin(int[] list, int start, int end){
        int minIndex = start;
        for (int i = start; i < end; i++){
            if (list[i] < list [minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    public static void swapElements(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}