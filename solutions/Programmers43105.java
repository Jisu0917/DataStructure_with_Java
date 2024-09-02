package solutions;

import java.util.*;

class Programmers43105 {
    public int[][] sum;
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        sum = new int[n][n];
        /*
        sum[0][0] = triangle[0][0];
        sum[1][0] = sum[0][0] + triangle[1][0];
        sum[1][1] = sum[0][0] + triangle[1][1];
        sum[2][0] = sum[1][0] + triangle[2][0];
        sum[2][1] = Math.max(sum[1][0], sum[1][1]) + triangle[2][1];
        sum[2][2] = sum[1][1] + triangle[2][2];
        sum[3][0] = sum[2][0] + triangle[3][0];
        sum[3][1] = Math.max(sum[2][0], sum[2][1]) + triangle[3][1];
        sum[3][2] = Math.max(sum[2][1], sum[2][2]) + triangle[3][2];
        sum[3][3] = sum[2][2] + triangle[3][3];
        */
        sum[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i-1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
            }
            sum[i][i] = sum[i-1][i-1] + triangle[i][i];
        }
        
        return Arrays.stream(sum[n-1])
            .max()
            .orElse(0);
      
    }
}