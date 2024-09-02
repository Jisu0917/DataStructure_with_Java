package solutions;

import java.util.*;

class Programmers42840 {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자
            if (answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
            // 2번 수포자
            if (answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
            // 3번 수포자
            if (answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }
        
        int[][] scores = {{1, score1}, {2, score2}, {3, score3}};
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 두 번째 요소인 score(점수)를 기준으로 내림차순 정렬
                return Integer.compare(b[1], a[1]);
            }
        });
        
        if (scores[0][1] == scores[1][1]) {
            if (scores[1][1] == scores[2][1]) {  // 1등, 2등, 3등 동일
                return new int[]{scores[0][0], scores[1][0], scores[2][0]};
            } else {  // 1등, 2등 동일
                return new int[]{scores[0][0], scores[1][0]};
            }
        } else {  // 1등 유일
            return new int[]{scores[0][0]};
        }
    }
}