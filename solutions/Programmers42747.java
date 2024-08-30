package solutions;

import java.util.*;

class Programmers42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);  // 0 1 3 5 6 (인용 횟수)
        
        int maxH = 0;
        int max_length = citations.length;  // 5
        for (int i = 0; i < max_length; i++) {
            int v = max_length - i;  // 5 4 3 2 1 (H-index)
            if (citations[i] >= v) {
                maxH = Math.max(maxH, v);
            }
        }
       
        return maxH;
    }
}