package cn.datacast.一.数据结构和算法概述;


/*
* 需求：
*   1、定义一个学生类，具有年龄和姓名两个属性，并通过Comparable接口提供比较规则
*   2、定义测试类，在测试类中测试方法Comparable getMax(Comparable c1, Comparable c2) 完成测试
*
* */
public class Student implements Comparable<Student>{
    private String usrname;
    private int age;

    public Student() {
    }

    public Student(String usrname, int age) {
        this.usrname = usrname;
        this.age = age;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "usrname='" + usrname + '\'' +
                ", age=" + age +
                '}';
    }

    // 比较的是年龄，所以用本身对象的年龄减去参数对象的年龄即可
    @Override
    public int compareTo(Student student) {
         return this.getAge() - student.getAge();
    }
}
