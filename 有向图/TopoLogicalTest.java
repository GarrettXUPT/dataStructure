package cn.datacast.有向图;

import cn.datacast.线性表.栈.Stack;

public class TopoLogicalTest {
    public static void main(String[] args) {
        // 准备有向图
        DiGraph diGraph = new DiGraph(6);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(0, 3);
        diGraph.addEdge(2, 4);
        diGraph.addEdge(3, 4);
        diGraph.addEdge(4, 5);
        diGraph.addEdge(1, 3);
        //  通过TopoLogical对象对有向图中的顶点进行排序
        TopoLogical topoLogical = new TopoLogical(diGraph);
        // 获取顶点的线性序列进行打印
        Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
         for (Integer w : order){
             sb.append(w + " ->");
         }
        String str =  sb.toString();
        int index = str.lastIndexOf("->");
        str = str.substring(0, index);
        System.out.println(str);

    }
}
