package cn.datacast.线性表.链表;

import java.util.Iterator;

// 单向链表
public class LinkedList <T> implements Iterable <T>{

    private Node head; // 头结点
    private int N ;  // 记录链表长度
    private Node n;

    /*
    *   创建一个单向链表对象
    * */
    public LinkedList(){
        this.head = new Node(null, null);
        this.N = 0;
    }

    /*
    *   空置线性表
    * */
    public void clear(){
        head.next = null;
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
     *  读取并返回线性表中第i个元素的值
     * */
    public T get(int i){
        // 通过循环，由头结点可是向后找，找i次就可以找到元素
        Node n = head.next;
        for(int index = 0; index < i; index++){
            n = n.next;
        }
        return (T) n.item;
    }

    /*
     *  向线性表中插入元素
     * */
    public void insert(T t){
        // 找到点前最后一个结点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        // 创建新节点保存元素
        Node newNode = new Node(t, null);
        // 将当前最后一个结点指向新节点
        n.next = newNode;
        // 使当前元素个数加一
        this.N = this.N + 1;
    }

    /*
     *  向线性表中指定位置插入元素
     * */
    public void insert(int i, T t){
        // 找到i位置前一个结点
        Node pre = head;  // 定义前一个结点
        for(int index = 0; index <= i - 1; index++){
            pre = pre.next;
        }
        // 找到i位置结点
        Node curr = pre.next;
        // 创建新节点，并且新节点需要指向原来i位置的结点
        Node newNode = new Node(t, curr);
        // 是原来i位置的前一个结点指向新节点
        pre.next = newNode;
        // 使链表长度加一
        N++;
    }

    /*
     *  删除并返回线性表中的第i个元素
     * */
    public T remove(int i){
        // 找到i位置前一个结点
        Node pre = head;
        for(int index = 0; index <= i - 1; index++){
            pre = pre.next;
        }
        // 找到i位置结点
        Node curr = pre.next;
        // 找到i位置下一个节点
        Node nextNode = curr.next;
        // 前一个结点指向下一个节点
        pre.next = nextNode;
        // 元素个数减一
        this.N = this.N - 1;
        return (T) curr.item;
    }

    /*
     *  返回线性表中首次出现的指定的数据元素的序号
     * */
    public int indexOf(T t){
        // 从头结点开始一次取出每一个结点，取出item与t进行比较
        Node n = head;
        for(int i = 0; n.next != null; i++){
            if (n.next.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return n.next != null;
            }

            @Override
            public T next() {
                n = n.next;
                return (T) n.item;
            }
        };
    }

    /*
    *   单向链表的翻转
    * */
    public void reverse(){
        // 判断当前链表是否为空，若为空链表，则结束运行，若不是，则调用重载的reverse方法完成翻转
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    /*
    *   翻转链表当前的某个结点，并将翻转后的结果进行返回
    * */
    public Node reverse(Node curr){
        if(curr.next == null){
            head.next = curr;
            return curr;
        }
        // 若不是尾结点，则递归翻转当前节点的下一个节点，返回值就是链表反转后当前节点的上一个节点
        Node pre = reverse(curr.next);
        // 让返回结点的下一个节点变为当前节点
        pre.next = curr;
        // 将当前节点的下一个节点变为null
        curr.next = null;
        return curr;
    }

    // 成员内部类
    public class Node <T> {


        public T item; // 存储数据
        public Node next;  // 指向下一个节点

        /*
         *   创建Node对象
         * */
        public Node(T t, Node next) {
            this.item = t;
            this.next = next;
        }
    }


}
