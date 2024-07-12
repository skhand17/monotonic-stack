package DesignGuru;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = new int[] {2, 1, 5, 6, 2, 3 ,1};
        int largestArea = largestRectArea(heights);
        System.out.println(largestArea);
    }

    public static int largestRectArea(int[] heights) {

        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = stack.peek() + 1;
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int j = heights.length - 1; j >= 0; j--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }

            if (stack.isEmpty())
                rightSmaller[j] = heights.length - 1;
            else
                rightSmaller[j] = stack.peek() - 1;
            stack.push(j);
        }
        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            maxArea = Math.max(maxArea, (heights[i] * (rightSmaller[i] - leftSmaller[i] + 1)));
        }
        return maxArea;
    }
}
