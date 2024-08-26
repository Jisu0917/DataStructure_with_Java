package nonlinear_structure;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class DfsWithMap {
    int n = 9;
    int[][] edges = {  /* 유방향 그래프 */
        {1, 2}, {1, 8}, {1, 9}, {2, 3}, {2, 6}, {3, 4}, {3, 5}, {3, 7}, {6, 8}
    };
    
    Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
    Map<Integer, Boolean> visited = new HashMap<>();
    
    public void dfs(int s) {
        for (int i : graph.get(s)) {
            if (visited.get(i) == false) {
                visited.put(i, true);
                System.out.println(s + " -> " + i);
                dfs(i);
            }
        }
    }
    
    public void initGraph() {
        // 그래프 정점 초기화
        for (int i = 1; i <= n; i++) {
            graph.put(i, new LinkedList<Integer>());
        }
        
        // 각 정점에 간선 정보 넣기
        for (int[] edge : edges) {
            graph.get(edge[0]).offer(edge[1]);
        }
        
        // 방문 맵 초기화
        for (int i = 1; i <= n; i++) {
            visited.put(i, false);
        }
    }

    /*
    public static void main(String[] args) {
    	DfsWithMap sol = new DfsWithMap();
        
        // 그래프 및 방문 배열 초기화
        sol.initGraph();
        
        // 1. 첫 정점을 방문한다.
        sol.visited.put(1, true);
        
        // 2. 인접한 정점 중 아직 방문하지 않은 정점을 방문한다.
        sol.dfs(1);
    }*/
}
