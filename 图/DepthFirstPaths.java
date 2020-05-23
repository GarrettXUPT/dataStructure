package cn.datacast.图;


import cn.datacast.线性表.栈.Stack;

// 路径查找，找到其中一条即可
public class DepthFirstPaths {

    private boolean[] marked;
    private int s;  // 路径起点
    private int[] edgeTo;  // 索引值代表顶点，只代表从起点s到当前顶点路径上的最后一个顶点,存储路径

    /*
    *   构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
    * */
    public DepthFirstPaths(Graph G, int s){
        // 构建一个和图顶点大小相同的的布尔数组
        marked = new boolean[G.V()];
        // 构建一个和图定点数一样大小的整形数组
        edgeTo = new int[G.V()];
        // 初始化起点
        this.s = s;
        // 搜索图G中起点为s的所有路径
        dfs(G, s);
    }

    /*
    *   使用深度搜索找出G图中v顶点的所有相邻顶点
    * */
    private void dfs(Graph G, int v){
        // 将当前顶点设置为已被搜索
        marked[v] = true;
        // 遍历v的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)){
            // 若单签顶点w没有被搜索过，则将edgeTo[w]设置为v，表示w的前一个顶点为v，并递归与w顶点相通的其他顶点
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /*
    *   判断v顶点与s顶点是否存在路径
    * */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /*
    *   找出从起点s到顶点v的路径(就是该路径经过的顶点)
    * */
    public Stack pathTo(int v){
        // 当前v顶点与s顶点不连通，所以直接返回null，没有路径
        if (!hasPathTo(v)){
            return null;
        }
        // 创建路径中所有经过的点的容器
        Stack<Integer> path = new Stack<>();
        // 第一次将当前顶点存进去，然后将x变化为到达当前顶点的前一个顶点edgeTo[x]，在把前一个顶点存进去，继续将x变换为到达前一个顶点的前一个顶点，
        // 继续存，直到x的值为s为止，相当于逆推法，最后将s放进去
        for(int x = v; x!=s; x = edgeTo[x]){
            // 将当前顶点存入容器
            path.push(x);
        }
        // 将顶点放入容器
        path.push(s);
        return path;
    }


}
