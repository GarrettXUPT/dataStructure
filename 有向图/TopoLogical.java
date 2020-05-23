package cn.datacast.有向图;

import cn.datacast.线性表.栈.Stack;

// 拓扑排序
public class TopoLogical {
    private Stack order;  // 顶点的拓扑排序

    /*
     *  构造拓扑排序对象
     * */
    public TopoLogical(DiGraph G){
        // 创建检测环对象，检测图G中是否有环
        DirectedCycle dCycle = new DirectedCycle(G);
        if (!dCycle.hasCycle()){
            // 若没有环，创建顶点排序对象，进行顶点排序
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /*
     *  判断图G是否有环
     * */
    public boolean isCycle(){
        return order == null;
    }

    /*
     *  获取拓扑排序的所有顶点
     * */
    public Stack order(){
        return order;
    }
}
