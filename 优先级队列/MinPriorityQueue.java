package cn.datacast.优先级队列;

public class MinPriorityQueue <T extends Comparable<T>>{

    private T[] items;
    private int N;

    /*
    *   创建容量为capacity的MinPriorityQueue对象
    * */
    public MinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /*
     *   判断索引i处的值是否小于索引j处的值
     * */
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /*
     *   交换i索引和j索引处的值
     * */
    private void exch(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /*
     *   删除队列中最小的元素并返回这个最大的元素
     * */
    public T delMin(){
        // 第一个位置就是元素值最大的位置
        T min = items[1];
        // 交换最后一个位置和第一个位置
        exch(1, N);
        // 删除第N个位置
        items[N] = null;
        N--;
        // 将交换后的第一个元素进行下沉操作
        sink(1);
        return min;
    }

    /*
     *   向队列中插入一个元素
     * */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /*
     *   使用上浮算法，使索引k处的值到达堆中合适的位置
     * */
    private void swim(int k){
        while (k > 1){
            // 若父节点小于子节点
            if(less(k, k / 2)){
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    /*
     *   使用下沉算法，使索引k处的值到达堆中合适的位置
     * */
    private void sink(int k){

        while (2 * k <= N){
            // 找出子节点中的最大值
            int min = 2 * k;
            if(2 * k + 1 <= N && less(2 * k + 1, 2 * k)){  // 存在右结点
                min = 2 * k + 1;
            }

            // 比较当前节点与子节点中的较大值，当前结点大于子节点，则结束循环
            if(less(k, min)){
                break;
            }
            exch(k, min);
            k = min;
        }
    }

    /*
     *   获取队列中元素的个数
     * */
    public int size(){
        return N;
    }

    /*
     *   判断队列是否为空
     * */
    public boolean isEmpty(){
        return N == 0;
    }

}
