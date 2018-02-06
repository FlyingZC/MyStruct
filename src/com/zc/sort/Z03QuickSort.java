package com.zc.sort;

public class Z03QuickSort {
	public static void main(String[] args) {
		int n[]={2377,343,454,23,45,76,45,6,7,8,45,57,346,2432};
		quickSort(n, 0,n.length-1);
		for(int i=0;i<n.length;i++)
			System.out.print(n[i]+"\t");
	}
	
	public static void quickSort(int n[],int low,int high){
		int pivot;
		if(low<high){
			pivot=partition(n,low,high);
			quickSort(n,low,pivot-1);
			quickSort(n, pivot+1, high);
		}
	}

	private static int partition(int[] n, int low, int high) {
		int pivotkey=n[low];
		while(low<high){
			while(low<high&&n[high]>=pivotkey)
				high--;
			swap(n,low,high);
			while(low<high&&n[low]<=pivotkey)
				low++;
			swap(n, low, high);
		}
		return low;
	}

	private static void swap(int[] n, int low, int high) {
		int temp;
		temp=n[low];
		n[low]=n[high];
		n[high]=temp;
		
	}
}
