package solutions;

import java.util.*;
import java.io.*;

public class BOJ2630 {
    static int N;
    static int[][] metrix;
    static int white;
    static int blue;

    public static void divide(int x, int y, int size) {
        // 모든 구역이 동일한 색상인지 확인
        int flag = metrix[x][y];
        boolean isUniform = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (metrix[i][j] != flag) {
                    isUniform = false;
                    break;
                }
            }
            if (!isUniform) break;
        }

        // 만약 구역이 동일한 색상이라면
        if (isUniform) {
            if (flag == 0) {
                white++;
            } else {
                blue++;
            }
        } else { // 그렇지 않다면 4분할하여 재귀 호출
            int newSize = size / 2;
            divide(x, y, newSize);  // 1사분면
            divide(x, y + newSize, newSize);  // 2사분면
            divide(x + newSize, y, newSize);  // 3사분면
            divide(x + newSize, y + newSize, newSize);  // 4사분면
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        metrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                metrix[i][j] = Integer.parseInt(strs[j]);
            }
        }
        white = 0;
        blue = 0;
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}
