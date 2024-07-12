package DesignGuru;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = new int[] {9, 7, 1};
        int[] nums2 = new int[] {1, 7, 9, 5, 4, 3};

        int [] ans = nextGreaterEle(nums1, nums2);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterEle(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()){
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
