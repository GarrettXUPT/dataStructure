package cn.datacast.一.数据结构和算法概述;

public class TestStudent {

    public static void main(String[] args) {
        // 创建两个Student对象，并调用getMax方法，完成测试
        Student student1 = new Student("Garrett", 22);
        Student student2 = new Student("Walker", 24);

        Comparable max = getMax(student1, student2);
        System.out.println(max);
    }



    public static Comparable getMax(Comparable c1, Comparable c2){
        //  若返回值小于零，则c1比c2小，反之，则c1比c2大，若reslut == 0，则c1和c2一样大
        int result = c1.compareTo(c2);
        if(result >= 0){
            return c1;
        }else {
            return c2;
        }

    }
}
