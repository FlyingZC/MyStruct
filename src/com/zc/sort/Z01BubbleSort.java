package com.zc.sort;

public class Z01BubbleSort {
	
	private static long start;
	private static long end;
	private static long time;
	private static int maxSize=10000;
	public static void main(String[] args) {
		
		System.out.println("冒泡排序1:");
		int a[] ={1,5,4,7,6,9,2,0,8};
		bubbleSort1(a);
		printArr(a);
		//
		System.out.println("冒泡排序2:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		bubbleSort2(a);
		printArr(a);
		//
		System.out.println("冒泡排序3:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		bubbleSort3(a);
		printArr(a);
		
		//
		System.out.println("冒泡排序4:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		bubbleSort4(a);
		printArr(a);
		
		//
		System.out.println("简单选择排序:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		selectSort(a);
		printArr(a);
		
		//直接插入排序
		System.out.println("直接插入排序:");
		a=new int[]{10,5,4,7,6,9,2,0,8};
		insertSort(a);
		printArr(a);
		
		//折半插入排序
		System.out.println("折半插入排序:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		binaryInsertSort(a);
		printArr(a);
		
		//希尔插入排序
		System.out.println("希尔插入排序:");
		a=new int[]{1,5,4,7,6,9,2,0,8};
		shellSort(a);
		printArr(a);
		
		
		/*
		int b[]=new int[maxSize];
		int c[]=new int[maxSize];
		for(int i=0;i<100;i++)
		{
			int rand=(int)(Math.random()*maxSize);
			b[i]=rand;
		}
		c=b;
		printArr(b);
		start=System.currentTimeMillis();
		bubbleSort1(b);
		end=System.currentTimeMillis();
		time=end-start;
		printArr(b);
		System.out.println("bubbleSort1用时:"+time);
		
		b=c;
		start=System.currentTimeMillis();
		bubbleSort2(b);
		end=System.currentTimeMillis();
		time=end-start;
		printArr(b);
		System.out.println("bubbleSort2用时:"+time);
		
		b=c;
		start=System.currentTimeMillis();
		bubbleSort3(b);
		end=System.currentTimeMillis();
		time=end-start;
		printArr(b);
		System.out.println("bubbleSort3用时:"+time);*/
		
		
	}
	
	//冒泡排序-交换.j初值比i大一
	public static void bubbleSort1(int[] arr){
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
					swap(arr,i,j);
			}
		}
	}
	
	//冒泡排序.j从最后和之前一个数比较.
	public static void bubbleSort2(int[] arr){
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=arr.length-1;j>i;j--)
			{
				if(arr[j]<arr[j-1])
					swap(arr,j,j-1);
			}
		}
	}
	
	//每一趟之前将flag设为false,若这一趟没有交换任何元素.则排序结束
	public static void bubbleSort3(int[] arr){
		boolean flag=true;
			for(int i=0;i<arr.length-1&&flag;i++)
			{
				flag=false;
				for(int j=arr.length-1;j>i;j--)
				{
					if(arr[j]<arr[j-1]){
						swap(arr, j, j-1);
						flag=true;
					}
				}
			}
	}
	
	//冒泡排序,每次将最大值放到最后
	public static void bubbleSort4(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	/**
	 * 12,34,15,57,8,9,56,34,78,46
	 * 12,15,34,8,9,56,34,57,46,78 d1
	 * 12,15,8,9,34,34,56,46,57,78 d2
	 * */
	
	
	
	
	//简单选择排序.每一趟选出所有数中的最小值放到最前.
	public static void selectSort(int arr[]){
		for(int i=0;i<arr.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				//arr[j]和arr[min]比较
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr,i,min);
		}
	}
	
	//直接插入排序.数组[0]作为哨兵.记录当前值
	public static void insertSort(int[] arr){
		//初始时.认为arr[0]有序.后面数组无序
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[i-1])
			{
				int temp=arr[i];
				int j=i-1;
				for(;arr[j]>temp;j--)
				{
					arr[j+1]=arr[j];
					if(j==0){
						arr[0]=temp;
						break;						
					}
				}
				if(j!=0)
				arr[j+1]=temp;
			}
		}
		
	}
	//折半插入排序.与直接插入排序相比,优点在于通过折半查找可以更快的确定要插入元素的位置
	public static void binaryInsertSort(int[] arr){
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int low=0;
			int high=i-1;
			//折半查找确定arr[i]应该放置的位置
			while(low<=high)
			{
				int mid=(low+high)/2;
				if(temp<arr[mid]){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}
			//移动
			for(int j=i;j>=low+1;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[low]=temp;
		}
		
	}
	
	//希尔排序shell(缩小增量排序):插入排序的一种
	public static void shellSort(int[] arr){
		//d为每一个组的长度.初始为数组长度
		int d=arr.length;
		while(true){
			for(int i=0;i<d;i++)
			{
				for(int j=i;j+d<arr.length;j+=d)
				{
					if(arr[j]>arr[j+d])
					{
						swap(arr,j,j+d);
					}
				}
			}
			if(d==1){break;}
			d--;
		}
	}
	
	//
	
	
	public static void swap(int arr[],int i,int j){
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
	}
}
