package cn.datacast.树的进阶;


public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private Node root; // 存储根节点
    private int N;  // 记录树中的元素
    private static final boolean RED = true;  // 红色连接标识
    private static final boolean Black = false;  // 黑色连接标识

    /*
    *   判断当前节点的父节点指向的连接是否为红色
    * */
    private boolean isRed(Node x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }

    /*
     *  左旋调整
     * */
    private Node rotateleft(Node h){
        // 获取h结点的右子节点，表示为x
        Node x = h.right;
        // 使x结点的左子节点称为h结点的右子节点
        h.right = x.left;
        // 让h称为x结点的左子节点
        x.left = h;
        // 让x结点的color属性等于h结点的color属性
        x.color = h.color;
        // 使h结点的color属性变为红色
        h.color = RED;
        return x;
    }

    /*
     *  右旋调整
     * */
    private Node rotateright(Node h){
        // 获取h结点的左子节点，表示为x
        Node x = h.left;
        // 让x结点的右子节点称为h结点的左子节点
        h.left = x.right;
        // 使h结点称为x结点的右子节点
        x.right = h;
        // 让x结点的color属性等于h结点的color属性
        x.color = h.color;
        // 让h结点的color属性为红色
        h.color = RED;
        return x;
    }

    /*
     *  颜色翻转，相当于完成拆分4-结点,降低树的高度，提高效率
     * */
    private void flipColors(Node h){
        // 当前节点变为红色
        h.color = RED;
        // 左子节点和右子节点变为黑色
        h.right.color = Black;
        h.left.color = Black;
    }

    /*
     *  在整个书上左插入操作
     * */

    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = Black;  // 根节点的颜色总是黑色
    }

    /*
     *  在指定的书上，完成插入操作，并返回添加元素后的新树
     * */
    private Node put(Node h, Key key, Value value){
        // 判断h是否为空，若为空，则直接返回一个红色的结点
        if (h == null){
            N++;
            return new Node(key, value, null, null, RED);
        }
        // 比较h结点的键值与key的大小
        int cmp = key.compareTo((Key) h.key);
        if (cmp < 0){
            // 继续向左
            h.left = put(h.left, key, value);
        }else if(cmp > 0){
            // 继续向右
            h.right = put(h.right, key, value);
        }else {
            // 发生值的替换
            h.value = value;
        }

        // 进行左旋,当前左子节点黑色，右子节点为红色，需要左旋
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateleft(h);
        }
        // 进行右旋,当前结点的左子节点和左子节点的左子节点都为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateright(h);
        }
        // 颜色反转,当前节点的左子节点和右子节点都为红色时，需要颜色反转
        if (isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        N++;
        return h;
    }

    /*
     *  根据key值，从树上找到对应的值
     * */
    public Value get(Key key){
        return get(root, key);
    }

    /*
     *  从指定的树上，找到key对应的值
     * */
    private Value get(Node x, Key key){
        if (x == null){
            return null;
        }
        // 比较x结点的键和key的大小
        int cmp = key.compareTo((Key) x.key);
        if(cmp < 0){
            // 向左查找
            return get(x.left, key);
        }else if(cmp > 0){
            // 向右查找
            return get(x.right, key);
        }else {
            return (Value) x.value;
        }
    }

    /*
     *  获取树中元素的个数
     * */
    public int size(){
        return N;
    }
}
