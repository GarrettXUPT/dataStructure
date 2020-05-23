package cn.datacast.有向图;

// 顶点排序
import cn.datacast.线性表.栈.Stack;

public class DepthFirstOrder {
    private boolean[] marked;  // 索引代表顶点，值表示当前顶点是否已被搜索
    private Stack reversePost;  // 使用栈，存储顶点序列

    /*
     *  创建顶点排序对象，生成顶点线性序列
     * */
    public DepthFirstOrder(DiGraph G){
        // 创建一个和图的定点数相同的marked数组
        marked = new boolean[G.V()];
        reversePost = new Stack<Integer>();
        // 遍历搜索图中的每一个顶点
        for(int v = 0; v < G.V(); v++){
            // 若当前顶点没有内搜索过，则继续搜索
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }

    /*
     *  基于深度优先搜索，生成顶点线性序列
     * */
    private void dfs(DiGraph G, int v){
        // 将当前顶点标志为已搜索
        marked[v] = true;
        // 遍历v顶点的领接表，得到每一个顶点w
        for(Object w : G.adj(v)){
            // 若当前顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if(!marked[(int)w]){
                dfs(G, (int)w);
            }
        }
        // 当前顶点已被搜索完毕，让当前顶点入栈
        reversePost.push(v);
    }

    /*
     *  获取顶点线性序列
     * */
    public Stack reversePost(){
        return reversePost;
    }
}
