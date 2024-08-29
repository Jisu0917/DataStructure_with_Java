package sort_algorithm;

import java.util.Arrays;

public class QuickSortForString {
    static String[] origin = {
        "Karina", "V", "Jiwon", "Suzy", "Dohyun", "Jisu", "Suzy", "Winter", "Wonyoung", "NingNing"
    };
    static String[] sorted = new String[origin.length];

    public static void quickSort(int start, int end) {
        if (start >= end || end >= origin.length) {
            return;
        }

        String pivot = sorted[(start + end) / 2]; // 피벗을 가운데 요소로 선택
        String[] less = new String[end - start + 1];
        String[] more = new String[end - start + 1];
        int l = 0, m = 0;

        // 피벗 기준으로 less와 more 배열에 요소를 분배
        for (int i = start; i <= end; i++) {
            String s = sorted[i];
            if (i != (start + end) / 2) { // 피벗은 제외하고 처리
                if (s.compareTo(pivot) < 0) {
                    less[l++] = s;
                } else {
                    more[m++] = s;
                }
            }
        }

        // less와 more 배열의 크기를 맞춤
        less = Arrays.copyOfRange(less, 0, l);
        more = Arrays.copyOfRange(more, 0, m);

        // 정렬된 배열에 less, pivot, more을 합침
        System.arraycopy(less, 0, sorted, start, less.length);
        sorted[start + less.length] = pivot;
        System.arraycopy(more, 0, sorted, start + less.length + 1, more.length);

        // 재귀 호출로 좌우 부분 정렬
        quickSort(start, start + less.length - 1); // less 부분 정렬
        quickSort(start + less.length + 1, end); // more 부분 정렬
    }

    public static void main(String[] args) {
        sorted = Arrays.copyOfRange(origin, 0, origin.length); // origin 배열 복사
        quickSort(0, origin.length - 1); // 퀵소트 실행
        System.out.println(Arrays.toString(sorted)); // 결과 출력
    }
}
