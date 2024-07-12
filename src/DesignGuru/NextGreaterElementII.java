package DesignGuru;

import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 7, 1, 2, 6, 0};

        int[] nge = nextGreaterElement(arr);
        for(int i : nge){
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=2*n-1; i>=0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i%n]){
                stack.pop();
            }

            if(i < n){
                if(!stack.isEmpty()){
                    nge[i] = stack.peek();

                }else {
                    nge[i] = -1;
                }
            }

            stack.push(arr[i%n]);
        }
        return nge;
    }
}
