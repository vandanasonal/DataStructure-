package searching;

import java.util.Scanner;

public class BinarySearch {
	 public static int binarySearch(int[] arr, int x) {
		 int low=0;
		 int high= arr.length-1;
		 int mid;
		 
		 while(low<=high) {
			 mid= (low+high)/2;                        
		 
		 if(arr[mid]<x) {
			 low= mid+1;
		 }
		 else if(arr[mid]>x) {
			 high=mid-1;
		 }
		 else { return mid;
		}
	} 
		 return -1;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new  Scanner(System.in);
	       
	       System.out.println("Enter the no. of elelments ");
	       int n= sc.nextInt();
	       
	       int[] arr = new int[n];
	       System.out.println(" enter the sorted elelments ");
	       for(int j=0; j<arr.length; j++) {
	    	   arr[j]= sc.nextInt();
	       }
	       System.out.println(" enter the elelment to be searched ");
	       int x= sc.nextInt();
	       
	      int result= binarySearch(arr,x);
	      System.out.println("element found at " + result);
	       sc.close();
	  
  }
	

}
