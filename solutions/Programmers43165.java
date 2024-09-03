package solutions;

import java.util.Arrays;

class Programmers43165 {
    public int count;
    public boolean[] visited;
    public int[] nums;
    public void dfs(int index, int num, int rest) {
        
        boolean isAllVisited = false;
        if (index >= nums.length - 1) {
            isAllVisited = true;
        }
        
        if (isAllVisited && rest - num != 0) {
            return;
        } else if (isAllVisited && rest - num == 0) {
            count++;
            return;
        } else {
            dfs(index + 1, nums[index+1], rest - num);
            dfs(index + 1, (-1) * nums[index+1], rest - num);
        }
        
    }
    
    public int solution(int[] numbers, int target) {
        count = 0;
        nums = numbers;
        int n = numbers.length;
        dfs(0, numbers[0], target);
        
        System.out.println("target : " + target);
        
        
        dfs(0, numbers[0] * (-1), target);
        
        return count;
    }
}