package cn.datacast.图;

// 加权无向边
public class Edge implements Comparable<Edge>{
    private int v;  // 顶点一
    private int w;  // 顶点二
    private double weight;  // 当前边的权重

    /*
    *   以权重、顶点w、v构造一个边对象
    * */
    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /*
    *   获取边上的权重
    * */
    public double weight(){
        return weight;
    }

    /*
     *  获取边上的一个点
     * */
    public int either(){
        return v;
    }

    /*
     *  获取边上的除了顶点vertex外的另一个顶点,当前权重比传入权重大，则返回1，小但会负一，相等返回0
     * */
    public int other(int vertex){
        if(vertex == v){
            // 若传入的顶点vertex是v，返回另一个顶点w
            return w;
        }else {
            // 若传入的顶点vertex不是v，则返回v即可
            return v;
        }
    }


    @Override
    public int compareTo(Edge o) {
        int cmp;
        if(this.weight() > ((Edge) o).weight()){
            // 若当前边的权重大于参数边that的权重，返回1
            cmp = 1;
        }else if(this.weight() < ((Edge) o).weight()){
            // 若当前边的权重小于参数边that的权重，返回-1
            cmp = -1;
        }else {
            // 若当前边的权重等于参数边that的权重，返回0
            cmp = 0;
        }
        return cmp;
    }
}
