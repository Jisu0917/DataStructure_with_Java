package solutions;

/*
 * 백준 실버 1
 * https://www.acmicpc.net/problem/1074
 * */

import java.util.*;
import java.io.*;

public class BOJ1074 {  //백준 제출시에는 클래스 명을 public class Main 으로 해야한다.
    static int N, r, c, answer = 0;
    
    public static void Z(int y, int x, int size) {
        if (size == 1) {
            return;
        }
        
        int half = size / 2;
        int area = half * half;

        if (r < y + half && c < x + half) { // 1사분면
            Z(y, x, half);
        } else if (r < y + half && c >= x + half) { // 2사분면
            answer += area;
            Z(y, x + half, half);
        } else if (r >= y + half && c < x + half) { // 3사분면
            answer += 2 * area;
            Z(y + half, x, half);
        } else { // 4사분면
            answer += 3 * area;
            Z(y + half, x + half, half);
        }
    }

    public static int solution() {
        int size = (int) Math.pow(2, N);
        Z(0, 0, size);
        return answer;
    }
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");

        N = Integer.parseInt(s1[0]);
        r = Integer.parseInt(s1[1]);
        c = Integer.parseInt(s1[2]);
        
        System.out.println(solution());
    }*/
}
