package cn.datacast.树;

public class Node<Key, Value> {
    public Node left;   // 记录左子节点
    public Node right;  // 记录有子节点
    public Key key;     // 存储健
    public Value value; // 存储值
    /*
    *   创建一个Node对象
    * */
    public Node(Key key, Value value, Node left, Node right){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
