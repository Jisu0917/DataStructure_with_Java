package nonlinear_structure;

import java.util.HashMap;
import java.util.Map;

public class GraphWithStringValues {
	/*
    public static void main(String[] args) {
        String[] vtxs = {
            "Apple", "Banana", "Cherry", "Dohyun", "Lee"
        };
        String[][] edges = {
            {"Apple", "Banana"}, {"Apple", "Cherry"}, {"Apple", "Lee"},
            {"Banana", "Dohyun"}, {"Banana", "Lee"}, {"Cherry", "Dohyun"}, {"Dohyun", "Lee"}
        };
        int n = vtxs.length;
        int[][] matrix = new int[n][n];

        // 정점과 인덱스 매핑
        Map<String, Integer> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            map.put(vtxs[index], index);
        }

        // matrix 배열에 간선 정보 업데이트
        for (String[] edge : edges) {
            int vi = map.get(edge[0]);
            int wi = map.get(edge[1]);

            if (vi < n && wi < n) {
                matrix[vi][wi] = 1;
                // matrix[wi][vi] = 1;  // 무방향 그래프의 경우
            } else {
                System.out.println("Invalid edge: " + edge[0] + " -> " + edge[1]);
            }
        }

        // matrix 배열 전체 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    */
}