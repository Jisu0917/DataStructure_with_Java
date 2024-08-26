package nonlinear_structure;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private int[][] matrix;
    private int[] numbers;
    private int[][] edges;

    // 생성자: 정점의 수 n과 간선 배열을 받아서 인접 행렬을 초기화
    public Graph(int[] numbers, int[][] edges) {
        int n = numbers.length;
        // 0-based 인덱스 사용 (배열 크기를 n으로 설정)
        matrix = new int[n][n];

        // 정점 번호와 인덱스를 매핑
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            map.put(numbers[index], index);
        }

        // 간선 정보를 사용하여 인접 행렬을 업데이트
        for (int[] edge : edges) {
            Integer vi = map.get(edge[0]);  // 정점의 인덱스
            Integer wi = map.get(edge[1]);  // 정점의 인덱스
            
            if (vi != null && wi != null) {  // 유효성 검사
                matrix[vi][wi] = 1;
                // matrix[wi][vi] = 1;  // 무방향 그래프의 경우
            } else {
                System.out.println("Invalid edge: " + edge[0] + " -> " + edge[1]);
            }
        }
    }

    // 그래프의 인접 행렬을 출력하는 메소드
    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        int[] numbers = {1, 4, 6, 7, 9}; // 정점 번호
//        int[][] edges = {
//            {1, 4}, {1, 6}, {1, 7}, {4, 6}, {6, 7}, {6, 9}
//        };
//        Graph graph = new Graph(numbers, edges);
//        graph.printMatrix();
//    }
}
