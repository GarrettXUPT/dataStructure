package cn.datacast.线性表.链表;

import java.util.Iterator;

public class TwoWayLinkedList <T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return n.next != null;
            }

            @Override
            public T next() {
                return (T) n.next.item ;
            }
        };
    }

    private TwoWayNode last;   // 记录尾结点
    private TwoWayNode head;   // 记录首结点
    private int N;    // 当前链表元素个数
    private TwoWayNode n;

    /*
    *   创建双向链表对象
    * */
    public TwoWayLinkedList(){
        // 初始化头结点和尾结点
        this.head = new TwoWayNode(null,null,null);
        this.last = null;
        // 初始化元素个数
        this.N = 0;
        this.n = head;
    }

    /*
     *   空置线性表
     * */
    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    /*
     *   判断线性表是否为空
     * */
    public boolean isEmpty(){
        return N == 0;
    }

    /*
     *   获取线性表中的元素个数
     * */
    public int length(){
        return N;
    }

    /*
     *  获取第一个元素
     * */
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return (T) head.next.item;
    }

    /*
     *  获取最后一个元素
     * */
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return (T) last.item;
    }


    /*
     *  读取并返回线性表中第i个元素的值
     * */
    public T get(int i){
        TwoWayNode n = head.next;
        for(int index = 0; index < i; index++){
            n = n.next;
        }
        return (T) n.item;
    }

    /*
     *  向线性表中插入元素
     * */
    public void insert(T t){
        // 若链表为空
        if(isEmpty()){
            // 创建新节点
            TwoWayNode newNode = new TwoWayNode(t, head, null);
            // 使新节点成为尾结点
            last = newNode;
            // 使头结点指向尾结点
            head.next = last;
        }else {
            TwoWayNode oldlast = last;
            // 创建新节点
            TwoWayNode newNode = new TwoWayNode(t, oldlast,null);
            // 使当前尾结点指向新节点
            oldlast.next = newNode;
            // 使新节点成为尾结点
            last = newNode;
        }
        N++;
    }

    /*
     *  向线性表中指定位置插入元素
     * */
    public void insert(int i, T t){
        // 找到i位置的前一个结点
        TwoWayNode pre = head;
        for(int index = 0; index < i; index++){
            pre = pre.next;
        }
        // 找到当前节点
        TwoWayNode curr = pre.next;
        // 创建新节点
        TwoWayNode newNode = new TwoWayNode(t, pre, curr);
        // 让i位置的前一个结点的下一个节点变为新节点
        pre.next = newNode;
        // 让i位置的前一个结点变为新节点
        curr.pre = newNode;

        N++;
    }

    /*
     *  删除并返回线性表中的第i个元素
     * */
    public T remove(int i){
        // 找到i位置的前一个结点
        TwoWayNode pre = head;
        for(int index = 0; index < i; index++){
            pre = pre.next;
        }
        // 找到i位置结点
        TwoWayNode curr = pre.next;
        // 找到i位置的下一个节点
        TwoWayNode nextNode = curr.next;
        //  使i位置的前一个结点的下一个节点变为i位置的下一个节点
        pre.next = nextNode;
        // 使i位置的下一个节点的上一个结点变为i位置的前一个节点
        nextNode.pre = pre;
        // 元素个数减一
        N--;
        return (T) curr.item;
    }

    /*
     *  返回线性表中首次出现的指定的数据元素的序号
     * */
    public int indexOf(T t){
        TwoWayNode n = head;
        for(int i = 0; n.next != null; i++){
            if(n.next.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
}
