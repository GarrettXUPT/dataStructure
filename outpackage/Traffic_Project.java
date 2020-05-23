package cn.datacast;

import cn.datacast.图.DepthFirstSearch;
import cn.datacast.图.Graph;
import cn.datacast.并查集.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traffic_Project {
    public static void main(String[] args) throws Exception {
        show02();
    }


    // 判断两地是否相通(使用图解决)
    public static void show02() throws Exception {
        // 构建一个缓冲区读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project.class.getClassLoader().getResourceAsStream("cn/datacast/traffic_project.txt")));
        // 读取城市数目，初始化Graph图
        int number = Integer.parseInt(br.readLine());
        Graph G = new Graph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(br.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = br.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }
        // 构建深度优先搜索对象
        DepthFirstSearch firstSearch = new DepthFirstSearch(G, 9);
        // 调用marked方法，判断8顶点和10顶点是否与起点9相同
        boolean flag1 = firstSearch.marked(10);
        boolean flag2 = firstSearch.marked(8);
        System.out.println("九号与八号公路是否相通: " + flag2);
        System.out.println("九号与十号公路是否相通: " + flag1);

    }



    // 还需要多少条道路可以使所有地方相通(并查集解决)
    public static void show01() throws IOException {
        // 构建一个缓冲区读取流
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project.class.getClassLoader().getResourceAsStream("cn/datacast/traffic_project.txt")));
        // 读取第一行数据20
        int totalnumber = Integer.parseInt(br.readLine());
        // 构建一个并查集对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalnumber);
        // 读取第二行数据7
        int roadNum = Integer.parseInt(br.readLine());
        // 循环读取7条道路
        for(int i = 1; i <= roadNum; i++){
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            // 调用并查集对象的union方法，使两个城市相通
            uf.union(p, q);
        }
        // 获取当前并查集中分组的数量减一，就可以得到还需要修建道路的数目
        int roads = uf.count() - 1;
        System.out.println("还需要" + roads + "条道路");
    }
}
