package binarysearch;

import java.util.Random;
import java.util.Scanner;


public class BinarySearch {

    
    // nextLine dùng để nhập 1 chuỗi String vào bán phím kết thúc bằng dấu xuống dong
    // nextInt để nhập 1 số nguyên vào bàn phím
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter search value:");
        int search = scanner.nextInt();
        int a[] = radomArray(length);
        displayArray("The unsorted array :",a);
        bubbleSort(a);
        displayArray("Sorted array :",a);
       
      
        int foundIndex = binarySearch(a, search, 0, length - 1);
        if (foundIndex == -1){
            System.out.println("Not Found");
        }else{
            System.out.println("\nFound " + search + " at index: " + foundIndex);
            
        }
        
    }
    // phương thức random 
    public static int[] radomArray(int n){
        Random rd = new Random();
        int a[]=new  int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = rd.nextInt(n);
        }
        return a;
    }
    

  
    // phương thức hiện thị 
    public static void displayArray(String msg ,int[] arr) {
        System.out.print(msg +"[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }
    
   // bubblesort sắp xếp 
    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

// dùng để search
    public static int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) { 
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }
}