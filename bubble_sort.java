package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

/*
*   冒泡排序适用的场景是待排序元素较少的时候
* */
public class bubble_sort {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 5, 6, 3, 2, 1};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    *   对数组a中的元素进行排序
    * */
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length - 1; i++){
            for (int j = i + 1; j < a.length; j++){
                if(greater(a[i], a[j])){
                    exch(a, i, j);
                }
            }
        }
    }

    /*
        判断v1是否大于v2
     */
    private static boolean greater(Comparable v1, Comparable v2){
        return v1.compareTo(v2) > 0;  // 若还条件成立，则v1大于v2
    }

    /*
    *   数组两元素的交换
    * */
    private static void exch(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
    *   整体代码
    * */
    public static void buble_sort(){
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 1; i++){
            for (int j = i + 1; j < arrLen; j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int ele : arr){
            System.out.println(ele);
        }
    }
}
