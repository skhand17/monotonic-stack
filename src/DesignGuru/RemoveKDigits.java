package DesignGuru;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "1901042";
        int k = 4;
        String num1 = "54321";
        int k1 = 5;
        String ans2 = removeKDigits(num1, k1);
        System.out.println(ans2);

        String ans = removeKDigits(num, k);
        System.out.println(ans);

    }

    public static String removeKDigits(String num, int k) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : num.toCharArray()) {

            while( k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for(int i=0; i<k; i++){
            stack.pop();
        }


        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
