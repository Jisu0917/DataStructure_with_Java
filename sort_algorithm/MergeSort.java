package sort_algorithm;

import java.util.Arrays;

public class MergeSort {
    static int[] arr = {5, 3, 7, 8, 6, 4, 6, 2, 1, 0, 9, 3, 6};
    static int[] sorted = new int[arr.length];

    public static void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(start, mid);
            sort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int i = start;     // 왼쪽 부분 배열의 첫 인덱스
        int j = mid + 1;   // 오른쪽 부분 배열의 첫 인덱스
        int k = start;     // 병합할 배열의 인덱스

        // 병합 과정
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        // 남은 왼쪽 부분 배열 복사
        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        // 남은 오른쪽 부분 배열 복사
        while (j <= end) {
            sorted[k++] = arr[j++];
        }

        // 병합된 결과를 원래 배열에 복사
        for (int l = start; l <= end; l++) {
            arr[l] = sorted[l];
        }
    }

    /*
    public static void main(String[] args) {
        sort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }*/
}
