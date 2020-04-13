package test.stack;


import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if (stack.isEmpty()){
                    return  false;
                }
                char topChar=stack.pop();
                if(s.charAt(i)=='('&&topChar!=')'){
                    return  false;
                }
                if(s.charAt(i)=='['&&topChar!=']'){
                    return false;
                }
                if ((s.charAt(i)=='{'&&topChar!='}')){
                    return  false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s="{[[]]}";
        boolean flag=isValid(s);
        System.out.println(flag);

    }
}
