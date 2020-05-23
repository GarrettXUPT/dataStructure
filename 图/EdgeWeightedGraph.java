package cn.datacast.图;

import cn.datacast.线性表.队列.Queue;

public class EdgeWeightedGraph {

    private int V;  // 记录顶点的数量
    private int E;  // 记录边的数量
    private Queue<Edge>[] adj;  // 邻接表

    /*
    *   创建一个包含有V个顶点的空加权无向图
    * */
    public EdgeWeightedGraph(int V){
        // 初始化顶点的数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    /*
    *   获取图中顶点的数量
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
     *  向加权无向图中添加一条边e
     * */
    public void addEdge(Edge e){
        // 获取边中的一个顶点
        int v = e.either();
        // 获取边中的另一个顶点
        int w = e.other(v);
        // 因为是无向图，所以边e需要同时出现在两个顶点的邻接表中
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        // 边的数量加一
        E++;
    }

    /*
     *  获取和顶点v关联的所有边
     * */
    public Queue adj(int v){
        return adj[v];
    }

    /*
     *  获取加权无向图的所有边
     * */
    public Queue edges(){
        // 创建一个队列，存储所有边
        Queue<Edge> allEdge = new Queue<>();
        // 遍历顶点，拿到每个顶点的邻接表
        for(int v = 0; v < this.V; v++){
            // 遍历邻接表，拿到邻接表中的每一条边
            for(Object e : adj(v)){
                e = (Edge)e;
                // 因为无向图中，每条边对象都会在两个顶点的邻接表中各出现一次，为了不重复获取，暂定：
                    // 除了当前顶点外，在获取e中的另一个顶点w，若v<w则添加，这样可以保证每条边只被统计一次
                if (((Edge) e).other(v) < v){
                    allEdge.enqueue((Edge) e);
                }
            }
        }
        return allEdge;
    }
}
