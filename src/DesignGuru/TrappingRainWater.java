package DesignGuru;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap(heights);
        System.out.println(ans);
    }
    public static int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int result = 0;
        while (leftPointer <= rightPointer) {

            if(height[leftPointer] <= height[rightPointer]) {
                if(height[leftPointer] >= leftMax){
                    leftMax = height[leftPointer];
                } else {
                    result += leftMax - height[leftPointer];
                }
                leftPointer++;
            } else {
                if(height[rightPointer] >= rightMax){
                    rightMax = height[rightPointer];
                } else {
                    result += rightMax - height[rightPointer];
                }
                rightPointer--;
            }
        }
        return result;
    }
}
