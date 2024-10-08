package solutions;

import java.io.*;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        
        // dp 배열 채우기
        for (int i = 2; i <= N; i++) {
            // 기본적으로 1을 빼는 경우 (즉, i-1에서 +1 연산)
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누는 경우 (i가 2의 배수일 때)
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누는 경우 (i가 3의 배수일 때)
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        // 결과를 출력
        System.out.println(dp[N]);
    }
}
