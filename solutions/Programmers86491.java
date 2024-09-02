package solutions;

class Programmers86491 {
    public int solution(int[][] sizes) {
        // 더 긴 쪽을 가로(w), 더 짧은 쪽을 세로(h)
        int[] widths = new int[sizes.length];
        int[] heights = new int[sizes.length];
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                widths[i] = sizes[i][0];
                heights[i] = sizes[i][1];
            } else {
                widths[i] = sizes[i][1];
                heights[i] = sizes[i][0];
            }
            if (widths[i] > maxW) {
                maxW = widths[i];
            }
            if (heights[i] > maxH) {
                maxH = heights[i];
            }
        }
        
        return maxW * maxH;
    }
}