package cn.datacast.图;

import cn.datacast.线性表.队列.Queue;

public class Graph {

    private int V = 0;  // 记录顶点的数量
    private int E;  // 记录边的数量
    private Queue<Integer>[] adj;  // 邻接表

    public Graph(int V){
        // 初始化定点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 初始化邻接表的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }


    /*
    *   获取图中定点数量
    * */
    public int V(){
        return V;
    }

    /*
    *   获取图中边的数量
    * */
    public int E(){
        return E;
    }

    /*
    *   向图中添加一条边v-w
    * */
    public void addEdge(int v, int w){
        // 将w添加到v的链表中，这样顶点v就多了一个相邻点
        adj[v].enqueue(w);
        // 将v添加到w的链表中，顶点w就多了一个相邻点
        adj[w].enqueue(v);
        // 边的数量自增1
        E++;
    }

    /*
    *   获取和点v相邻的所有顶点
    * */
    public Queue<Integer> adj(int v){
        return adj[v];
    }


}
