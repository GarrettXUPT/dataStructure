package cn.datacast;

import cn.datacast.图.DepthFirstPaths;
import cn.datacast.图.Graph;
import cn.datacast.线性表.栈.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DepthFirstPathsTest {
    public static void main(String[] args) throws Exception {
        //创建输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("src\\cn\\datacast\\图\\road_find.txt")));
        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Graph G = new Graph(number);
        //读取城市的连通道路
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }

        //根据图G和顶点0路径查找对象
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);

        //调用查找对象的pathTo(4)方法得到路径
        Stack<Integer> path = paths.pathTo(4);

        //遍历打印
        StringBuilder sb = new StringBuilder();
        for(Integer v : path){
            sb.append(v + "_");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
