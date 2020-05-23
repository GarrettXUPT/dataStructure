package cn.datacast.树的进阶;

public class Node<Key extends Comparable<Key>, Value> {
    public Node left;  // 记录左子节点
    public Node right;  // 记录右子节点
    public Key key;
    public Value value;
    public boolean color;  // 由其父节点指向它的连接的颜色

    public Node(Key key, Value value, Node left, Node right, boolean color){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }
}
