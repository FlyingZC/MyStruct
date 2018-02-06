package com.zc.sort;
/**
 * 归并排序
 * */
public class Z02MergeSort {
	public static int[] sort(int[] nums,int low,int high){
		int mid=(low+high)/2;
		if(low<high){
			//左边
			sort(nums,low,mid);
			//右边
			sort(nums,mid+1,high);
			//左右归并
			merge(nums,low,mid,high);
		}
		return nums;
	}

	private static void merge(int[] nums, int low, int mid, int high) {
		int[] temp=new int[high-low+1];
		int i=low;//左指针
		int j=mid+1;//右指针
		int k=0;
		
		//把较小的数移到新数组
		while(i<=mid&&j<=high){
			if(nums[i]<nums[j]){
				temp[k++]=nums[i++];
			}else{
				temp[k++]=nums[j++];
			}
		}
		
		//把剩余的数移入数组
		while(i<=mid){
			temp[k++]=nums[i++];
		}
		while(j<=high){
			temp[k++]=nums[j++];
		}
		
		//用新数组中的数覆盖nums数组
		for(int m=0;m<temp.length;m++){
			//
			nums[m+low]=temp[m];
		}
	}
	
	public static void main(String[] args) {
		int[] nums={299,30,4,35,28,3234,45,234,4,67,23,56,78};
		Z02MergeSort.sort(nums, 0, nums.length-1);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");			
		}
	}
}
