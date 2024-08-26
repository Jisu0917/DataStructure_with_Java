package nonlinear_structure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphWithStringValues2 {
    static String[] vtxs = {"Apple", "Banana", "Cherry", "Dohyun", "Lee"};
    static String[][] edges = {
        {"Apple", "Banana"}, {"Apple", "Cherry"}, {"Apple", "Lee"},
        {"Banana", "Dohyun"}, {"Banana", "Lee"}, {"Cherry", "Dohyun"}, {"Dohyun", "Lee"}
    };

    /*
    public static void main(String[] args) {
        // 그래프 초기화
        Map<String, LinkedList<String>> graph = createGraph(vtxs, edges);

        // 그래프 출력
        printGraph(graph);
    }

    // 그래프를 생성하는 메서드
    private static Map<String, LinkedList<String>> createGraph(String[] vertices, String[][] edges) {
        Map<String, LinkedList<String>> graph = new HashMap<>();

        // 정점 초기화
        for (String vtx : vertices) {
            graph.put(vtx, new LinkedList<>());
        }

        // 간선 추가
        for (String[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            // 무방향 그래프인 경우 아래 줄을 추가
            // graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    // 그래프를 출력하는 메서드
    private static void printGraph(Map<String, LinkedList<String>> graph) {
        for (Map.Entry<String, LinkedList<String>> entry : graph.entrySet()) {
            String vtx = entry.getKey();
            LinkedList<String> adjList = entry.getValue();
            for (String neighbor : adjList) {
                System.out.println(vtx + " -> " + neighbor);
            }
        }
    }
    */
}
