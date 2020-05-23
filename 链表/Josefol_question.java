package cn.datacast.线性表.链表;

// 约瑟夫问题
/*
*
*   问题转换：
*       1、41个人坐一圈，第一个人编号为1，第二个人编号为2，第n个人编号为n
*       2、编号为1的人开始从1报数，一次向后，报数为3的人退出圈
*       3、支腿出那个人的下一个人从1开始报数，依次类推
*       4、求最后退出那个人的编号
*
*   解决思路：
*       1、构建含有41个结点的单向循环链表，分别存储1-41的值，代表41个人
*       2、使用计数器count，记录当前报数的值
*       3、遍历链表没循环一次count++
*       4、判断count的值，若是3，则从链表中删除这个节点打印节点的值，将count重置为0
* */
public class Josefol_question {
    public static void main(String[] args) {
        // 解决约瑟夫问题
        // 1、构建循环链表，存储1-41的值
        Node<Integer> first = null;  // 用来记录首结点
        Node<Integer> pre = null;    // 用来记录当前节点的亲一个节点
        for(int i = 1; i <= 41; i++){
            // 若是第一个节点
            if(i == 1){
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            // 若不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            // 若是最后一个节点，那么需要让最后一个节点的下一个节点变为first,变为循环列表
            if(i == 41){
                pre.next = first;
            }
        }
        // 2、需要count计数器，模拟报数
        int count = 0;
        // 3、遍历链表,记录每次遍历拿到的节点，默认从首结点开始
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n != n.next){  // n为唯一的元素
            // 模拟报数
            count++;
            // 判断当前报数是否为3
            if(count == 3){
                // 若是3，则把当前节点删除调用，打印当前节点，重置count为0，使当前节点n后移
                before.next = n.next;
                System.out.println(n.item + ", ");
                count = 0;
                n = n.next;
            }else {// 若不是3，则before变为当前节点，让当前节点后移
                before = n;
                n = n.next;
            }
        }
        // 打印最后一个元素
        System.out.println(n.item);
    }
}
