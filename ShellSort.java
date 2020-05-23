package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 1, 7, 8, 2, 3, 6, 0, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *   对数组a中的元素进行排序
    * */
    public static void sort(Comparable[] a){
        int N = a.length;
        // 确定增长量h的最大值,即初始值
        int h = 1;
        while (h < N / 2){
            h = 2 * h + 1;
        }

        // 当增长量小于1时，排序结束
        while (h >= 1){
            // 找到待插入的元素，第一个待插入元素就是h
            for (int i = h; i < a.length; i++){
                // 将待插入的元素插入到有序数列中，j的初始值就是待插入元素
                for (int j = i; j >= h; j = j - h){
                    // 待插入元素是a[j]，比较a[j]和a[j - h]
                    if(greater(a[j - h], a[j])){
                        exch(a, j - h, j);
                    }else {
                        // 待插入元素已经找到合适的位置，结束循环
                        break;
                    }
                }
            }
            h = h / 2;
        }
    }

    /*
        判断v1是否大于v2
     */
    private static boolean greater(Comparable v1, Comparable v2){
        return v1.compareTo(v2) > 0;  // 若还条件成立，则v1大于v2
    }

    /*
         数组两元素的交换
     * */
    private static void exch(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
