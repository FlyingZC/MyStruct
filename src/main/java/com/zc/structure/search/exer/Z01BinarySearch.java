package com.zc.structure.search.exer;

public class Z01BinarySearch
{
    public int binarySearch(int[] array, int key)
    {
        int low = 0, high = array.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (key > array[mid])
            {
                low = mid + 1;
            }
            else if(key < array[mid])
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
