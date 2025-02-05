import java.util.Scanner; // for input

public class MaxMinElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        System.out.print("Enter the number of elements : ");
        int x = sc.nextInt(); // size of array
        arr = new int[x];

        System.out.println("Enter the array elements ");
        for(int i = 0;i<x;i++) {
            arr[i] = sc.nextInt(); // taking array elements
        }

        int max,min;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i = 0;i<x;i++) {
            if(arr[i]>max) max = arr[i];
            if(arr[i]<min) min = arr[i];
        }
        System.out.println("Max value : "+max+"\nMin value : "+min);
        sc.close(); // closing the scanner object
    }
}
