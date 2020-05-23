package cn.datacast.一.数据结构和算法概述;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    *   对数组内元素进行排序
    * */
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    /*
    *   对数组a中从索引lo到hi之间的元素进行排序
    * */
    public static void sort(Comparable[] a, int lo, int hi){
        // 安全性校验
        if(lo >= hi){
            return;
        }
        // 需要对数组中lo到hi索引处的数组进行分组(左子组，右子组)
        int partition = partition(a, lo, hi); // 返回的是分界值的索引，是分界值位置变换后的索引
        // 使左子组有序
        sort(a, lo, partition - 1);
        // 使右子组有序
        sort(a, partition + 1, hi);
    }

    /*
    *   对数组a，从lo到hi之间的元素进行分组，并返回分组界限对应的索引
    * */
    public static int partition(Comparable[] a, int lo, int hi){
        // 确定分界值，定义指向待切分元素的最小处索引处和最大索引处的下一个位置
        Comparable key = a[lo];
        int left = lo;
        int right = hi + 1;
        // 切分
        while(true){
            // 先向右往左扫描，移动right指针，先找到一个分界值小的元素，停止
            while(less(key, a[--right])){
                if(right == lo) {
                    break;
                }
            }

            // 再从左向右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left], key)){
                if(left == hi){
                    break;
                }
            }
            // 交换元素，判断right是否大于等于left，若是，则证明元素扫描完毕，结束循环，若不是，则交换元素
            if(left >= right){
                break;
            }else {
                exch(a, left, right);
            }
        }
        // 交换分界值
        exch(a, lo, right);
        // 返回分界值所在的索引
        return right;
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
