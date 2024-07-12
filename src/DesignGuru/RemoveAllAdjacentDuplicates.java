package DesignGuru;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        String s = "abbbaaca";
        int k = 3;

        String sol = removeDuplicates(s, k);
        System.out.println(sol);
    }

    public static String removeDuplicates(String s, int k) {

        Stack<int[]> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()[0] == c){
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
            if(stack.peek()[1] == k){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            sb.append(String.valueOf((char) top[0]).repeat(top[1]));
        }

        return sb.reverse().toString();
    }
}
