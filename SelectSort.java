package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 5, 6, 2, 1, 4, 3, 7, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        对数组内元素进行排序
    */
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length - 2; i++){
            // 假定本次遍历，最小值所在的索引是i
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++){
                if(greater(a[minIndex], a[j])){
                    // 更新最小值索引
                    minIndex = j;
                }
            }
            // 交换最小元素和第一个元素
            exch(a, i, minIndex);
        }
    }

    /*
        判断v1是否大于v2
     */
    private static boolean greater(Comparable v1, Comparable v2){
        return v1.compareTo(v2) > 0;  // 若还条件成立，则v1大于v2,返回true
    }

    /*
        数组两元素的交换
     */
    private static void exch(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
