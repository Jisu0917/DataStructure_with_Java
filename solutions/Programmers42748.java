package solutions;

import java.util.Arrays;

class Programmers42748 {
    public int[] sorted;
    
    public void quickSort(int start, int end) {
        if (start < 0 || end > sorted.length || start > end) {
            return;
        }
        
        int pivot = sorted[(start+end)/2];  // 중간점을 피벗으로 설정
        int[] less = new int[end - start + 1];
        int[] more = new int[end - start + 1];
        int l = 0;
        int m = 0;
        for (int i = start; i <= end; i++) {
            if (i != (start+end)/2) {
                // 피벗은 제외하고 처리
                if (sorted[i] < pivot) {
                    less[l++] = sorted[i];
                } else {
                    more[m++] = sorted[i];
                }
            }
        }
        
        // 길이에 맞게 배열 자르기
        less = Arrays.copyOfRange(less, 0, l);
        more = Arrays.copyOfRange(more, 0, m);
        
        // sorted 배열에 정렬된 구간만 복사
        System.arraycopy(less, 0, sorted, start, less.length);
        sorted[start + less.length] = pivot;
        System.arraycopy(more, 0, sorted, start + less.length + 1, more.length);
        
        // less, more 각각에 대해 퀵 정렬 수행
        quickSort(start, start + less.length - 1);
        quickSort(start + less.length + 1, end);
        
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] copy = array;
        
        int i, j, k, count = 0;
        for (int[] command : commands) {
            i = command[0];  //2
            j = command[1];  //5
            k = command[2];  //3
            
            array = copy;
            
            // 배열 자르기
            array = Arrays.copyOfRange(array, i-1, j);   //origin, start, end
            
            // array를 정렬
            sorted = array;
            quickSort(0, array.length - 1);
            
            // k 번째 숫자 = 인덱스 k - 1
            answer[count] = sorted[k-1];
            count++;
        }
        
        return answer;
    }
}