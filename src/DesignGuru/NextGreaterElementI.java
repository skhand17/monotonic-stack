package DesignGuru;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {

        int[] nums1 = new int[]{4, 2, 6};
        int[] nums2 = new int[]{6, 2, 4, 5, 3, 7};


        int[] nge = nextGreaterElement(nums1, nums2);
        for(int n: nge){
            System.out.print(n + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();


        for(int n: nums2) {

            while(!stack.isEmpty() && n > stack.peek()){
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;

    }
}
