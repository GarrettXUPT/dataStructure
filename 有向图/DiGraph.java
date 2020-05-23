package cn.datacast.有向图;

import cn.datacast.图.Graph;
import cn.datacast.线性表.队列.Queue;

public class DiGraph {

    private int V;  // 记录顶点数量
    private int E;  // 记录边的数量
    private Queue[] adj;  // 邻接表

    /*
    *   创建一个包含V个顶点但不包含边的有向图
    * */
    public DiGraph(int V){
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = E;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    /*
    *   获取图中定点的数量
    * */
    public int V(){
        return V;
    }

    /*
    *   获取图中边的数量
    * */
    private int E(){
        return E;
    }

    /*
     *  向有向图中添加一条边v->w
     * */
    public void addEdge(int v, int w){
        // 有向图中的边是有向的，v->w边，只需要让w出现在v的邻接表中，而不需要让v出现在邻接表中
        adj[v].enqueue(w);
        // 边的数目加一
        E++;
    }

    /*
     *  获取由v指出的边所连接的所有的顶点
     * */
    public Queue adj(int v){
        return adj[v];
    }

    /*
     *  该图的反向图
     * */
    private DiGraph reverse(){
        // 创建新的有向图对象
        DiGraph r = new DiGraph(V);
        // 遍历所有顶点，拿到每一个顶点
        for (int i = 0; i < V; i++) {
            // 得到原图中顶点对应的邻接表，原图中的变为v->w，反向图中的变就是w——>v
            for (Object w : adj(i)) {
                r.addEdge((int)w, i);
            }
        }
        return r;
    }
}
