package cn.datacast.线性表.队列;

// 单向结点类
public class Node<T>{


    public T item; // 存储数据
    public Node next;  // 指向下一个节点

    /*
    *   创建Node对象
    * */
    public Node(T t, Node next){
        this.item = t;
        this.next = next;
    }

//    public static void main(String[] args) {
//        // 构建结点
//        Node<Integer> first = new Node<>(11, null);
//        Node<Integer> second = new Node<>(12, null);
//        Node<Integer> third = new Node<>(13, null);
//        Node<Integer> fourth = new Node<>(14, null);
//        Node<Integer> fifth = new Node<>(15, null);
//
//        // 生成链表
//        first.next = second;
//        second.next= third;
//        third.next = fourth;
//        fourth.next = fifth;
//    }
}
