package cn.datacast.有向图;

public class DirectedCycle {

    private boolean[] marked;  // 索引代表定哪个店，值表示当前顶点是否已被搜索
    private boolean hasCycle;  // 记录图中是否有环
    private boolean[] onStack;  // 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上

    /*
     *  创建一个检测环对象，检测图G中是否有环
     * */
    public DirectedCycle(DiGraph G){
        // 创建一个与图的定点数一样大小的marked数组
        marked = new boolean[G.V()];
        // 创建一个和图的顶点数一样大小的onStack数组
        onStack = new boolean[G.V()];
        // 默认没有环
        hasCycle = false;
        // 遍历搜索图中的每一个顶点
        for (int i = 0; i < G.V(); i++) {
            // 若当前顶点没有被搜索过，则进行搜索
            if(!marked[i]){
                dfs(G, i);
            }
        }
    }

    /*
     *  基于深度优先搜索，检测图G中是否有环
     * */
    private void dfs(DiGraph G, int v){
        // 将当前顶点标记为已搜索
        marked[v] = true;
        // 让当前顶点进栈
        onStack[v] = true;
        // 遍历v顶点的邻接表，得到每一个顶点
        for (Object w : G.adj(v)){
            // 若当前顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if(!marked[(int)w]){
                dfs(G, (int)w);
            }
            // 若顶点w已经被搜索过，那么查看是否在栈中，若在，说明图中有环，修改hasCycle标记，结束循环
            if(onStack[(int)w]){
                hasCycle = true;
                return;
            }
        }
        // 当前顶点已被搜索完毕，让当前顶点出栈
        onStack[v] = false;
    }

    /*
     *  记录图中是否有环
     * */
    public boolean hasCycle(){
        return hasCycle;
    }

}
