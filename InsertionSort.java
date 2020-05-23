package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] arr = {9, 8, 5, 6, 2, 1, 4, 3, 7, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *   对数组a中的元素进行排序
    * */
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            // 倒序遍历，当前元素为a[i]，依次和i前面的元素比较，找到一个小于等于a[i]的元素
            for(int j = i; j > 0; j--){
                if(greater(a[j - 1], a[j])){
                    exch(a, j - 1, j);
                }else {
                    // 找到该元素，结束
                    break;
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
}
