package searching;

import java.util.Scanner;

public class LinearSearch {
	public static void lSearch(int[] arr, int x) {
		for(int i=0; i<arr.length; i++ ) {
			if( arr[i]== x) { 
				System.out.println(" element found at " + i );
			}
		}
				
		System.out.println(" element not found " );	
	}
	
 public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new  Scanner(System.in);
       
       System.out.println("Enter the no. of elelments ");
       int n= sc.nextInt();
       
       int[] arr = new int[n];
       System.out.println(" enter the elelments ");
       for(int j=0; j<arr.length; j++) {
    	   arr[j]= sc.nextInt();
       }
       System.out.println(" enter the elelment to be searched ");
       int x= sc.nextInt();
       
       lSearch(arr,x);
       sc.close();
	}

}
