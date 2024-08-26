package nonlinear_structure;

import java.util.HashMap;
import java.util.Map;

public class GraphWithValues {
	/*
    public static void main(String[] args) {
        int[] numbers = {1, 4, 6, 7, 9}; // 정점 번호
        int[][] edges = {
            {1, 4}, {1, 6}, {1, 7}, {4, 6}, {6, 7}, {6, 9}
        };
        
        int n = numbers.length;
        int[][] matrix = new int[n][n];
        
        // 숫자와 인덱스를 매핑하기 위한 Map 생성
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(numbers[i], i);
        }
        
        // Initialize matrix with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        
        // Update matrix based on edges
        for (int[] edge : edges) {
            Integer u = indexMap.get(edge[0]);
            Integer v = indexMap.get(edge[1]);
            
            if (u != null && v != null) {
                matrix[u][v] = 1;
            } else {
                System.out.println("Invalid edge: " + edge[0] + " -> " + edge[1]);
            }
        }
        
        // Print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    */
}
