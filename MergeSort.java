package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static Comparable[] assit;

    /*
    *   对数组内元素进行排序
    * */
    public static void sort(Comparable[] a){
        // 初始化辅助数组assit定义io变量和hi变量
        assit = new Comparable[a.length];
        // 分别记录数组中最小的索引和最大的索引
        int io = 0;
        int hi = a.length - 1;
        // 调用sort重载方法完成数组中，从索引io到索引hi的元素排序
        sort(a, io, hi);
    }

    /*
    *   对数组a中的从索引i到索引j之间的元素进行排序
    * */
    private static void sort(Comparable[] a, int io, int hi){
        // 安全性校验：
        if(hi <= io){
            return;
        }
        // 对io到hi之间的数组分为两个组
        int mid = io +  (hi - io) / 2;
        // 分完组以后，分别对每一组数据进行排序
        sort(a, io, mid);
        sort(a, mid + 1, hi);
        // 对两个组中的数据进行归并
        merge(a, io, mid, hi);
    }

    /*
    *   从索引io到mid是一个子组，从索引mid + 1到索引hi为另一个子组，将数组a中的两个子组的数据合并为一个有序的大组
    * */
    private static void merge(Comparable[] a, int io, int mid, int hi){
        // 定义三个指针
        int i = io;
        int p1 = io;
        int p2 = mid + 1;
        // 遍历，移动p1指针和p2指针，比较对应索引处的值，找出最小的，放到辅助数组的对应索引处
        while (p1 <= mid && p2 <= hi){
            // 比较对应索引处的值
            if(less(a[p1], a[p2])){
                assit[i++] = a[p1++];  // 将p1数组放到辅助数组中
            }else {
                assit[i++] = a[p2++];
            }
        }
        // 遍历，若p1指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数据的对应索引处
        while (p1 <= mid){
            // 顺序取出p1所指的数组中的元素，放到辅助数组中即可
            assit[i++] = a[p1++];
        }
        // 遍历，若p2指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数据的对应索引处
        while (p2 <= hi){
            assit[i++] = a[p2++];
        }
        // 将辅助数组中的元素拷贝到原数组中
        for (int index = io; index <= hi; index++){
            a[index] = assit[index];
        }
    }

    /*
    *   判断v1是否小于v2
    * */
    private static boolean less(Comparable v1, Comparable v2){
        return v1.compareTo(v2) < 0;
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
