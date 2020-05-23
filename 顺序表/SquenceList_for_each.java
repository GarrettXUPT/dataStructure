package cn.datacast.线性表.顺序表;

public class SquenceList_for_each {
    public static void main(String[] args) {
        SquenceList<String> squenceList = new SquenceList<>(5);
        squenceList.insert("Garrett");
        squenceList.insert("Walker");
        squenceList.insert("Shiyu");
        for(String s : squenceList){
            System.out.println(s);
        }
    }
}
