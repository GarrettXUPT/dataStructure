package cn.datacast.线性表.链表;

public class the_use_of_List {

    public static void main(String[] args) {
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        // 产生环
//        seventh.next = third;
        // 判断链表是否有环
        boolean circle = isCircle(first);
        System.out.println(circle);


    }

    /*
    *   使用快慢指针解决中间值问题
    * */
    public static int getMid(Node<Integer> first){
        // 定义两个结点
        Node<Integer> fast = first;
        Node<Integer> slow = first;
        // 使用两个指针遍历链表  当快指针指向的结点没有下一个节点，就可以结束，并返回满指针指向的结点(中间值)
        while (fast != null && fast.next != null){
            // 变换fast和slow的值
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    public static void show01(){
        // 构建结点
        Node<Integer> first = new Node<>(11, null);
        Node<Integer> second = new Node<>(12, null);
        Node<Integer> third = new Node<>(13, null);
        Node<Integer> fourth = new Node<>(14, null);
        Node<Integer> fifth = new Node<>(15, null);

        // 生成链表
        first.next = second;
        second.next= third;
        third.next = fourth;
        fourth.next = fifth;
        int mid = getMid(first);
        System.out.println(mid);
    }

    /*
    *   解决是否有环问题
    * */
    public static boolean isCircle(Node<String> first){
        // 定义快慢指针
            Node<String> fast = first;
            Node<String> slow = first;
        // 遍历链表：若快慢指针指向了同一个结点，这说明有环，否则没环
        while (fast != null && fast.next != null){
            // 变换fast和slow
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /*
    *   若有环，确定环的入口
    *   当快慢指针相遇时，判断有环，这时设置一个新的指针指向链表的起点，且步长与满指针一样为1，则满指针与新指针相遇时就是环的入口
    * */
    public static Node getEntrance(Node<String> first){
        // 定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        // 遍历链表，先找到环(快慢指针相遇)，准备一个临时指针，指向链表的首结点，继续遍历，直到满指针与临时指针相遇，那么相遇的
        // 地方就是环的入口
        while (fast != null && fast.next != null){
            // 变换fast和slow
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                temp = first;
                continue;
            }

            // 使临时结点变换
            if(temp != null){
                temp = temp.next;
                // 判断临时指针是否与满指针相遇
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }
}
