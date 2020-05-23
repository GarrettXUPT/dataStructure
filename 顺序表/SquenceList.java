package cn.datacast.线性表.顺序表;

import java.util.Iterator;
import java.util.Objects;

public class SquenceList<T> implements Iterable<T>{

    // 实现该类才能使用增强for循环建立该类中的元素
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return cursor < N;
            }

            @Override
            public T next() {
                return eles[cursor++];
            }
        };
    }

    private T[] eles;  // 存储元素的数组
    private int N;     // 当前线性表的长度
    private int cursor;  // 遍历顺序表需要的指针

    /*
    *   创建容量为capacity的对象
    * */
    public SquenceList(int capacity){
        // 初始化数组
        this.eles = (T[] )new Object[capacity];
        // 初始化长度
        this.N = 0;
        // 初始化指针
        this.cursor = 0;
    }

    /*
    *   空置线性表
    * */
    public void clear(){
        this.N = 0;
    }

    /*
    *   判断线性表是否为空
    * */
    public boolean isEmpty(){
        return N == 0;
    }

    /*
    *   获取线性表中元素的个数
    * */
    public int length(){
        return N;
    }

    /*
    *   获取线性表中第i个元素的值
    * */
    public T get(int i){
        return eles[i];
    }

    /*
    *   在线性表的第i个元素之前插入一个值为t的数据元素
    * */
    public void insert(int i, T t){

        if(N == eles.length){
            resize(2 * eles.length);
        }

        // 先将i索引处的元素及其后面的元素一次向后移动一位
        for(int index = N - 1; index > i; index--){
            eles[index] = eles[index - 1];
        }
        // 在将t元素放入i索引处即可
        eles[i] = t;
        N++;
    }

    /*
    *   向线性表中添加一个元素
    * */
    public void insert(T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    /*
    *   删除并返回线性表中第i个元素
    * */
    public T remove(int i){
        // 记录索引i处的值
        T current = eles[i];
        // 使索引i后面的元素依次向前移动一位即可
        for(int index = i; index < N - 1; index++){
            eles[index] = eles[index + 1];
        }
        this.N = this.N - 1;

        if(N < eles.length / 4){
            resize(eles.length / 2);
        }

        return current;
    }

    /*
    *   返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
    * */
    public int indexOf(T t){
        for(int i = 0; i < N; i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    /*
    *   在插入元素或者移除元素时，根据参数newsize，重置eles的大小
    * */
    public void resize(int newsize){
        // 定义一个临时数组，指向原数组
        T[] temp = eles;
        // 创建新数组
        eles = (T[] )new Object[newsize];
        // 将原数组数据拷贝到新数组
        for(int i = 0; i < N; i++){
            eles[i] = temp[i];
        }
    }
}
