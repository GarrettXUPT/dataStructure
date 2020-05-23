package cn.datacast.图;

import cn.datacast.线性表.队列.Queue;

public class BreadthFirstSearch {

    private boolean[] marked;  // 索引代表结点，值表示当前顶点是否已经被搜索
    private int count;  // 记录有多少个结点与s顶点相同
    private Queue waitSearch;  // 用来存储待搜索邻接表的点

    /*
    *   构造广度优先搜索对象，使用广度优先搜索找出G图中s顶点的所有相邻顶点
    * */
    public BreadthFirstSearch(Graph G, int s){
        // 创建一个与图定点数一样大小的布尔数组
        marked = new boolean[G.V()];
        count = 0;
        // 初始化带搜索顶点的队列
        waitSearch = new Queue<Integer>();
        // 搜索G图中与顶点s相同的所有顶点
        bfs(G, s);
    }

    /*
    *   使用广度优先搜索找出G图中v顶点的相邻顶点
    * */
    private void bfs(Graph G, int v){
        // 将当前顶点标记为已被搜索
        marked[v] = true;
        // 将当前顶点v放到队列中，等待搜索它的邻接表
        waitSearch.enqueue(v);
        // 使用while循环从队列中拿出带搜索的顶点wait，进行搜索邻接表
        while (!waitSearch.isEmpty()){
            Integer wait = (Integer) waitSearch.dequeue();
            // 遍历wait的邻接表，得到每一个顶点w
            for (Integer w : G.adj(wait)){
                if (!marked[w]){
                    bfs(G, w);
                }
            }
        }
        count++;
    }

    /*
    *   记录s顶点相通的所有顶点的总数
    * */
    private int count(){
        return count;
    }

    /*
    *   判断w顶点是否与s顶点相通
    * */
    public boolean marked(int w){
        return marked[w];
    }
}
