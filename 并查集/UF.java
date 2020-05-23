package cn.datacast.并查集;

public class UF {

    private int[] eleAndGroup;
    private int count;
    /*
     *  初始化并查集，以整数表示(0 - N-1)结点
     * */
    public UF(int N){
        // 初始化分组的数量，默认情况下有N个分组
        this.count = N;
        // 初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        // 初始化eleAndGroup中的元素及所在组的标识,需要使eleAndGroup数组的索引作为并查集的每个结点的元素
        // 使每个索引处(该元素所在的组的标识符)的值，就是该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
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
        // 判断元素p、q是否已经在同一分组中，若在，则结束
        if(connected(p, q)){
            return;
        }
        // 找到p所在分组的标识符，再找到q所在分组的标识符，
        int pGroup = find(p);
        int qGroup = find(q);
        // p所在组的所有元素的组标识符变为q所在分组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            if(eleAndGroup[i] == pGroup){
                eleAndGroup[i] = qGroup;
            }
        }
        count--;
    }

    /*
    *   查询元素p所在的标识符
    * */
    public int find(int p){
        return eleAndGroup[p];
    }
}
