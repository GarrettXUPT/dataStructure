package cn.datacast.并查集;

// 路径压缩代码，可优化原来的并查集，防止线性树的产生
public class UF_Tree_Weighted {

    private int[] eleAndGroup;  // 记录并查集中数据有多少分组
    private int count;      // 记录并查集中数组分组的个数
    private int[] sz;  // 存储每个根节点对用的树中的元素个数

    public UF_Tree_Weighted(int N){
        // 初始化分组的数量，默认情况下有N个分组
        this.count = N;
        // 初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        this.sz = new int[N];
        // 初始化eleAndGroup中的元素及所在组的标识,需要使eleAndGroup数组的索引作为并查集的每个结点的元素
        // 使每个索引处(该元素所在的组的标识符)的值，就是该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    /*
     *   获取当前并查集中的数据有多少组
     * */
    public int count(){
        return count;
    }

    /*
     *   判断并查集中元素p和元素q是否处于同一分组
     * */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /*
     *   将p元素所在分组和q元素所在分组进行合并
     * */
    public void union(int p, int q){
        // 找到p元素和q元素所在组对应数的根节点
        int pRoot = find(p);
        int qRoot = find(q);
        // 若q、p已经在同一个分组，就不需要合并了
        if(pRoot == qRoot){
            return;
        }
        // 比较p所在树的元素个数和q所在树的元素个数,把较小的树合并到较大的树上
        if (sz[pRoot]<sz[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            //重新调整较大树的元素个数
            sz[qRoot] = sz[pRoot] + sz[qRoot];
        }else{
            eleAndGroup[qRoot]=pRoot;
            sz[pRoot]= sz[qRoot] + sz[pRoot];
        }
        //分组数量-1
        count--;
    }

    /*
     *   查询元素p所在的标识符
     * */
    public int find(int p){
        while (true){
            //// 判断当前元素p的父结点eleAndGroup[p]是不是自己，如果是自己则证明已经是根结点了
            if(p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }
}
