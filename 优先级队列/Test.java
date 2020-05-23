package cn.datacast.优先级队列;

public class Test {

        public static void main(String[] args) {
            test02();

        }

        public static void test01(){
            //创建最小优先队列对象
            MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
            //往队列中存数据
            queue.insert("G");
            queue.insert("F");
            queue.insert("E");
            queue.insert("D");
            queue.insert("C");
            queue.insert("B");
            queue.insert("A");

            //通过循环获取最小优先队列中的元素
            while(!queue.isEmpty()){
                String min = queue.delMin();
                System.out.print(min+" ");
            }
        }

        public static void test02(){
            //创建索引最小优先队列对象
            IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);

            //往队列中添加元素
            queue.insert(0,"A");
            queue.insert(1,"C");
            queue.insert(2,"F");

            //测试修改
            queue.changeItem(2,"B");

            //测试删除
            while(!queue.isEmpty()){
                int index = queue.delMin();
                System.out.print(index+ " ");
            }
        }
}
