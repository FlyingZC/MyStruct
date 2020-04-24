package com.zc.structure.search;

import java.util.Arrays;

/*二分搜索必须先排序*/
public class T01BinarySearch
{
    public static void main(String[] args)
    {
        int a[] = {1, 56, 23, 45, 5765, 324, 213, 34, 21, 32};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int index = binarySearch(a, 213);
        System.out.println(index);//7
    }

    /**
     * 二分查找 方法,根据要查找的元素,找到它在数组中的下标
     * @param a 要查找元素的数组,该数组必须有序
     * @param key 要查找的元素
     * @return
     */
    public static int binarySearch(int[] a, int key)
    {
        int low = 0, high = a.length - 1;
        //为什么是high>=low,假设现在查找的是最后一个元素.
        while (high >= low)
        {
            int mid = (low + high) / 2;
            if (key > a[mid])
            {
                low = mid + 1;
            }
            else if (key < a[mid])
            {
                high = mid - 1;
            }
            else
            {
                //说明找到了
                return mid;
            }
        }
        return -1;
    }
}
