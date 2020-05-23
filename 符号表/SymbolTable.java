package cn.datacast.线性表.符号表;



public class SymbolTable<Key extends Comparable<Key>, Value>{

    private Node head;  // 记录首结点
    private int N;  // 巨鹿符号表中键值对的个数

    /*
     *  创建SymbolTable对象
     * */
    public SymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    /*
     *  根据key，获取value
     * */
    public Value get(Key key){
        Node n = head;
        while (n.next != null){
            // 变换n
            n = n.next;
            if(n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
    }

    /*
     *  向符号表中插入一个键值对,无序
     * */
    public void put(Key key, Value val){
        // 若符号表中已经存在了键为key的键值对，那么只需要找到该结点，替换值为value即可
        Node n = head;
        while (n.next != null){
            // 变换n
            n = n.next;
            // 判断n结点存储的键是否为key，若是，则替换n结点的值
            if(n.key.equals(key)){
                n.value = val;
                return;
            }
        }
        // 若符号表中不存在键为key的键值对，只需要创建新的结点，保存插入的键值对，将新的结点插入到链表的头部，head.next为新节点即可
        Node newNode = new Node(key, val, null);
        Node oldNode = head.next;
        head.next = newNode;
        newNode.next = oldNode;
        N++;

    }

    /*
     *  向符号表中插入一个键值对,有序
     * */
    public void putOrder(Key key, Value val){
        // 定义Node变量，分别记录当前节点和当前节点的上一个结点
        Node curr = head.next;
        Node pre = head;
        while (curr != null && key.compareTo((Key) curr.key) > 0){
            // 变换当前节点和前一个结点
            pre = curr;
            curr = curr.next;
        }
        // 若当前节点的key和要插入的key一样，则进行替换，
        if (curr != null && key.compareTo((Key) curr.key) == 0){
            curr.value = val;
            return;
        }
        // 若当前节点的键和要插入的key不一样，则将结点插入到curr之前
        Node newNode = new Node(key, val, curr);
        pre.next = newNode;
        N++;
    }

    /*
     *  删除键位key的键值对
     * */
    public void delete(Key key){
        // 找到键为key的键值对，将该结点从链表中删除
        Node n = head;
        while (n.next != null){
            // 判断n结点的下一个节点的键是否为key，若是，就删除该结点
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
            }
            n = n.next;
        }
    }

    /*
     *  获取符号表的大小
     * */
    public int size(){
        return N;
    }

    private class Node<Key, Value>{

        public Key key; // 存储键
        public Value value;  // 存储值
        public Node next;  // 存储下一个节点

        /*
        *   构造Node对象
        * */
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
