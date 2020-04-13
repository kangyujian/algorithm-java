package test.stack;

import stack.ArrayStack;
import stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new ArrayStack<>();
        for (int i=0;i<10;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
