package cn.datacast.树;

import cn.datacast.线性表.队列.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {

    private Node root;  // 记录当前根节点
    private int N;  // 记录树中元素

    /*
    *   创建BinaryTree对象
    * */
    public BinaryTree(){
        this.root = null;
        this.N = 0;
    }

    /*
     *  向树中插入一个键值对
     * */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    /*
     *  给指定的树上，添加一个键值对，并返回添加后的新树
     * */
    private Node put(Node x, Key key, Value value){
        // 若x子树为空树
        if(x == null){
            N++;
            return new Node(key, value, null, null);
        }
        // 若x子树不为空，比较x结点的键和key的大小
        int cmp = key.compareTo((Key) x.key);
        if (cmp > 0){
            // 若key大于x结点的键，继续找x结点的右子树
            x.right = put(x.right, key, value);
        }else if(cmp < 0){
            // 若key小于x结点的键，继续找x结点的左子树
            x.left = put(x.left, key, value);
        }else {
            // 若key等于x结点的键，则替换x结点的值为value
            x.value = value;
        }
        return x;
    }

    /*
     *  根据key，从树中找到对应的值
     * */
    public Value get(Key key){
        return get(root, key);
    }

    /*
    *   从指定的树中，查找key对应的值
    * */
    public Value get(Node x, Key key){
        // x为null
        if(x == null){
            return null;
        }
        // x不为null
        // 比较key与x中结点key的大小
        int cmp = key.compareTo((Key) x.key);
        if(cmp > 0){
            // 若key大于x结点的键，继续找x结点的右子树
            return get(x.right, key);
        }else if(cmp < 0){
            // 若key小于x结点的键，继续找x结点的左子树
            return get(x.left, key);
        }else {
            // 若key等于x结点的键,就找到了键为key的结点，只需要返回x结点的值即可
            return (Value) x.value;
        }
    }

    /*
    *   删除key中对应的value
    * */
    public void delete(Key key){
        delete(root, key);
    }

    /*
     *  删除树中对应的键值对
     * */
    private Node delete(Node x, Key key){
        // x树为null
        if(x == null){
            return null;
        }
        // x树不为null
        // 比较key与x中键的大小
        int cmp = key.compareTo((Key) x.key);
        if(cmp > 0){
            // 若key大于x结点的键，继续找x结点的右子树
            x.right = delete(x.right, key);
        }else if(cmp < 0){
            // 若key小于x结点的键，继续找x结点的左子树
            x.left = delete(x.left, key);
        }else {
            N--;
            // 若key等于x结点的键,就找到了键为key的结点，完成删除动作
            // 需要找到右子树中，最小的结点
            if (x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            Node minMode = x.right;
            while (minMode.left != null){
                minMode = minMode.left;
            }
            // 删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }
            // 使x结点的左子树成为minNode的左子树
            minMode.left = x.left;
            // 让x结点的右子树成为minNode的右子树
            minMode.right = x.right;
            // 让x结点的父节点指向minNode
            x = minMode;
        }

        return x;
    }

    /*
     *  获取树中的元素个数
     * */
    public int size(){
        return N;
    }

    /*
    *   查找二叉树中最小的键
    * */
    public Key min(){
        return (Key) min(root).key;
    }

    /*
     *   查找二叉树中最小的键所在的结点
     * */
    public Node min(Node x){
        if(x.left != null) {
            return min(x.left);
        }else {
            return x;
        }
    }

    /*
     *   查找二叉树中最大的键
     * */
    public Key max(){
        return (Key)max(root).key;
    }

    /*
     *   查找二叉树中最大的键所在的结点
     * */
    public Node max(Node x){
        if(x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }


    /*
    *   前序遍历，获取整个树中的所有键
    * */
    public Queue<Key> preErogodic(){
        Queue<Key> keys = new Queue<>();
        preErogodic(root, keys);
        return keys;
    }


    /*
     *   使用前序遍历，将指定树中的所有键值放入key队列中
     * */
    private void  preErogodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        // 将当前节点的key放入队列中
        keys.enqueue((Key) x.key);
        // 递归遍历x结点的左子树
        if(x.left != null){
            preErogodic(x.left, keys);
        }
        // 递归遍历x的右子树
        if (x.right != null){
            preErogodic(x.right, keys);
        }
    }

    /*
     *   中序遍历，获取整个树中的所有键
     * */
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    /*
     *   使用中序遍历，将指定树中的所有键值放入key队列中
     * */
    private void midErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        // 找到当前节点的左子树，若不为空，则递归遍历左子树
        if(x.left != null){
            midErgodic(x.left, keys);
        }
        // 将当前节点的key放入队列中
        keys.enqueue((Key) x.key);

        if(x.right != null){
            midErgodic(x.right, keys);
        }

    }

    /*
     *   后序遍历，获取整个树中的所有键
     * */
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    /*
     *   使用后序遍历，将指定树中的所有键值放入key队列中
     * */
    private void afterErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        // 找到当前节点的左子树，若不为空，则递归遍历左子树
        if(x.left != null){
            midErgodic(x.left, keys);
        }

        if(x.right != null){
            midErgodic(x.right, keys);
        }
        // 将当前节点的key放入队列中
        keys.enqueue((Key) x.key);
    }

    /*
    *   层序遍历从根节点为第一层开始，依次向下，获取每一层所有结点的值
    * */
    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            Node x = nodes.dequeue();
            keys.enqueue((Key) x.key);
            if(x.left != null){
                nodes.enqueue(x.left);
            }
            if(x.right != null){
                nodes.enqueue(x.right);
            }
        }
        return keys;
    }

    /*
    *   计算树的最大深度
    * */
    public int maxDepth(){
        return maxDepth(root);
    }

    /*
    *   计算指定树的最大深度
    * */
    private int maxDepth(Node x){
        // 若根节点为空，则最大深度为0
        if(x == null){
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;

        // 计算左子树最大深度
        if(x.left != null){
            maxL = maxDepth(x.left);
        }
        // 计算右子树最大深度
        if(x.right != null){
            maxR = maxDepth(x.right);
        }
        // 求出当前树的最大深度，即为左右子树最大值加一
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }





}
