package cn.datacast.线性表.栈;

public class The_use_of_stack {
    public static void main(String[] args) {
        show03();
    }

    // 括号检查
    public static void show02(){
        String str = "(上海(长安)()))";
        boolean match = isMatch(str);
        System.out.println("字符串中括号是否匹配: " + match);
    }

    public static boolean isMatch(String str){
        // 创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        // 由左向右遍历字符串，拿到字符串后，判断当前括号是否为左括号，若是，将字符放入到栈中
        for (int i = 0; i < str.length(); i++){
            String currChar = str.charAt(i) + "";
            if(currChar.equals("(")){
                chars.push(currChar);
                // 若不是，则判断当前括号是否为右括号，若是，则从栈中弹出左括号，病哦判断弹出结果是否为null，若是，则证明没有匹配，相反，则匹配
            }else if(currChar.equals(")")) {
                String popchar = chars.pop();
                if (popchar == null) {
                    return false;
                }
            }
        }
        // 判断栈中是否还有剩余的组括号，若有，则证明括号不匹配
        if (chars.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    // 解决逆波兰表达式
    public static void show03(){
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果是：" + result);
    }

    public static int calculate(String[] strs){
        // 创建一个栈，存储操作数
        Stack<Integer> operands = new Stack<>();
        // 从左向右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            // 判断当前元素是运算符还是操作数，若是运算符，则从栈中弹出两个操作数进行运算，运算完的结果压入栈中
            Integer o1, o2, result;
            switch (curr) {
                case "+":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2+ o1;
                    operands.push(result);
                    break;
                case "-":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 - o1;
                    operands.push(result);
                    break;
                case "*":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 * o1;
                    operands.push(result);
                    break;
                case "/":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 / o1;
                    operands.push(result);
                    break;
                default:
                    // 若是操作数，则将操作数放入栈中就可以
                    operands.push(Integer.parseInt(curr));
                    break;
            }
        }
        // 得到栈中最后一个元素，就是逆波兰表达式的结果
        return operands.pop();
    }
}
