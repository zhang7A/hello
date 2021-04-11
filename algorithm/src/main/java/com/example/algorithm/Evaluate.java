package com.example.algorithm;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 输入(1 + ((2 + 3) * (4 * 5))) 计算得值
 */
public class Evaluate {

    private static List<String> typeList = Lists.newArrayList(")", "+", "-", "*");

    public static void main(String[] args) {
        Stack<String> typeStack = new Stack<String>();
        Stack<Double> numberStack = new Stack<Double>();

        String evaluateNumber = "(1+((2+3)*(4*5)))";

        for (int i = 0; i < evaluateNumber.length(); i++) {
            String temp = String.valueOf(evaluateNumber.charAt(i));
            if (typeList.contains(temp)) {
                if (")".equals(temp)) {
                    //开始计算
                    Double num2 = numberStack.pop();
                    Double num1 = numberStack.pop();
                    String type = typeStack.pop();
                    Double tempEvaluateNum = Double.NaN;
                    switch (type) {
                        case "+":
                            tempEvaluateNum = num1 + num2;
                            break;
                        case "-":
                            tempEvaluateNum = num1 - num2;
                            break;
                        case "*":
                            tempEvaluateNum = num1 * num2;
                            break;
                        default:
                    }
                    numberStack.push(tempEvaluateNum);
                    continue;
                }
                //放置字符
                typeStack.push(temp);
            } else if ("(".equals(temp)) {
                //不处理
            } else {
                //放置数字
                numberStack.push(Double.parseDouble(temp));
            }
        }
        System.out.println(numberStack.pop());
    }
}
