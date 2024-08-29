package solutions;

import java.util.PriorityQueue;
import java.io.*;

public class BOJ1927 {
	static PriorityQueue<Integer> queue;
	static int N;
	
	public BOJ1927() {
		queue = new PriorityQueue<>();
	}
	/*
	public static void main(String[] args) throws IOException {
		BOJ1927 main = new BOJ1927();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int exec;
        for (int i = 0; i < N; i++) {
            exec = Integer.parseInt(br.readLine());
            if (exec == 0) {
				if (queue.isEmpty()) {
                    System.out.println(0);
				} else {					
					System.out.println(queue.poll());
				}
			} else {
				queue.offer(exec);
			}
        }
	}*/
}