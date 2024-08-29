package solutions;

import java.util.PriorityQueue;

class Programmers42626 {
    public int solution(int[] scoville, int K) {        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.offer(s);
        }
         
        int count = 0;
        while (heap.size() >= 2) {
            
            if (heap.peek() >= K) {
                return count;
            }
            
            int jisu = heap.poll() + ( 2 * heap.poll() );
            
            heap.offer(jisu);
           
            count++;
            
        }
        
        if (heap.peek() >= K) {
            return count;
        }
        
        return -1;
    }
}