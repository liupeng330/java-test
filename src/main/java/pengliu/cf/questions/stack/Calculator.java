package pengliu.cf.questions.stack;

import pengliu.cf.MyStack;

/**
 * Created by peng on 10/8/17.
 */
//将操作数和左括号压入vals栈中
//将操作符压入ops栈中
//遇到右括号时，vals弹出操作数，ops弹出操作符，计算结果重新压入vals栈中。
//上面的过程直到遇到vals栈顶是左括号为止，将左括号弹出，将计算结果压入vals栈中
public class Calculator {
    private MyStack<String> vals = new MyStack<>();
    private MyStack<String> ops = new MyStack<>();

    private String[] input;

    public Calculator(String[] input) {
        this.input = input;
    }

    private int cal(String valA, String valB, String ops) {
        int first = Integer.parseInt(valB);
        int second = Integer.parseInt(valA);

        switch(ops) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
        }
        throw new RuntimeException("Ops is not supported!!");
    }

    private boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOps(String a) {
        return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/");
    }

    public int getResult() {
        for(int i=0; i<input.length; i++) {
            String curr = input[i];
            if(isNumber(curr) || curr.equals("(")) {
                vals.push(curr);
            }
            else if(isOps(curr)) {
                ops.push(curr);
            }
            else if(curr.equals(")")) {
                for(;;) {
                    Integer ret = cal(vals.pop(), vals.pop(), ops.pop());
                    if(vals.peek().equals("(")) {
                        vals.pop();
                        vals.push(ret.toString());
                        break;
                    }
                    else {
                        vals.push(ret.toString());
                    }
                }
            }
        }
        while(vals.size() > 1) {
            Integer ret = cal(vals.pop(), vals.pop(), ops.pop());
            vals.push(ret.toString());
        }
        return Integer.parseInt(vals.pop());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new String[]{"5", "-", "(", "2", "*", "(", "3", "-", "4", ")", ")"});
        System.out.println(calculator.getResult());
    }
}
