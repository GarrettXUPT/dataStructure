package cn.datacast.堆;

import java.util.Objects;

public class Heap<T extends Comparable<T>>{

    private T[] items;  // 用来存储元素的数组
    private int N;  // 记录堆中元素的个数

    /*
    *   创建容量为capacity的Heap对象
    * */
    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /*
    *   判断堆中索引i处元素是否小于索引j处元素
    * */
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /*
     *  交换堆中i索引与j索引处的值
     * */
    private void exch(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /*
     *  删除堆中的最大元素，并返回该值,最大值就是对应二叉树的根节点
     * */
    public T delMax(){
        T max = items[1];
        // 交换索引N与索引1处的值
        exch(1, N);
        // 删除最后位置上的元素
        items[N] = null;
        N--;
        sink(1);  // 一次与子节点中较大者进行交换
        return max;
    }

    /*
     *  向堆中插入一个元素
     * */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /*
     *  使用上浮算法，是索引k处的元素能在堆中处于一个正确的位置
     * */
    private void swim(int k){
        // 若已经到了根节点，就不再需要循环了
        while (k > 1){
            // 比较当前节点与其父节点
            if(less(k / 2, k)){
                // 若父节点小于当前节点，则需要交换
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    /*
     *  使用下沉算法，使索引k处的元素可以在堆中处于一个正确的位置
     * */
    private void sink(int k){
        // 若当前以及是最底层，就停止循环,通过循环比较当前节点与左右子节点的大小关系
        while (2 * k <= N){
            // 找到子节点中的较大值
            int max;
            if(2 * k + 1 <= N){ // 存在右子节点

                if(less(2 * k, 2 * k + 1)){
                    max = 2 * k + 1;
                }else {
                    max = 2 * k;
                }

            }else {  // 不存在右结点
                max = 2 * k;
            }
            // 比较当前节点与子节点中的较大者，若当前节点大，则结束循环
            if(!less(k, max)){
                break;
            }else {
                exch(k, max);
                k = max;
            }
        }
    }
}
