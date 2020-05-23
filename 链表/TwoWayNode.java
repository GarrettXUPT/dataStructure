package cn.datacast.线性表.链表;

public class TwoWayNode <T>{

    public T item;  // 存储数据
    public TwoWayNode next;  // 指向下一个节点
    public TwoWayNode pre;   // 指向上一个结点

    // 创建双向链表对象
    public TwoWayNode(T t, TwoWayNode pre, TwoWayNode next){
        this.item = t;
        this.pre = pre;
        this.next = next;
    }


}
