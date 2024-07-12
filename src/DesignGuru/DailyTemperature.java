package DesignGuru;

import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] temperature = new int[] {70, 73, 75, 71, 69, 72, 76, 73};
        int[] temp = new int[] {73, 72, 71, 70};
        int[] ans2 = dailyTemperature(temp);
        for(Integer i : ans2){
            System.out.print(i + " ");
        }
        System.out.println();

        int[] ans = dailyTemperature(temperature);
        for(Integer i: ans){
            System.out.print(i + " ");
        }
    }
    public static int[] dailyTemperature(int[] temperature) {

        int[] result = new int[temperature.length];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperature.length; i++){
            while(!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }
}
