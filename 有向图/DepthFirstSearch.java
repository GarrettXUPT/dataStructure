package cn.datacast.有向图;


import cn.datacast.图.Graph;

public class DepthFirstSearch {

    private boolean[] marked;  // 索引代表的顶点，值表示该顶点已经被搜索
    private int count;  // 记录多少个顶点，与S顶点相通

    /*
    *   构造深度优先搜索对象，使用深度优先搜索找到G图中s顶点所有的互通顶点
    * */
    public DepthFirstSearch(Graph G, int s){
        // 创建一个与图顶点数一样大小的布尔数组
        count = 0;
        marked = new boolean[G.V()];
        // 搜索G图中与顶点s相同的所有顶点
        dfs(G, s);

    }

    /*
    *   使用深度优先搜索找出G图中v顶点的所有相通顶点
    * */
    private void dfs(Graph G, int v){
        // 将当前顶点标志为一搜索
        marked[v] = true;
        // 遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)){
            // 若当前顶点没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if(!marked[w]){
                dfs(G, (w));
            }
        }
        // 相通顶点的数量加一
        count++;
    }

    /*
    *   获取与顶点s相同的所有顶点的总数
    * */
    public int count(){
        return count;
    }

    /*
    *   判断w顶点与s顶点是否相通
    * */
    public boolean marked(int w){
        return marked[w];
    }

    public static void main(String[] args) {
        Graph G = new Graph(13);
        G.addEdge(0, 5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 6);
        G.addEdge(5, 3);
        G.addEdge(5, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 6);
        G.addEdge(7, 8);
        G.addEdge(9, 11);
        G.addEdge(9, 10);
        G.addEdge(9, 12);
        G.addEdge(11, 12);
        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        int count = search.count();
        System.out.println(count);

        boolean marked1 = search.marked(5);
        System.out.println(marked1);

    }



}
