package sort_algorithm;

import java.util.Arrays;

public class MergeSortForString {
	static String[] arr = {
		"Karina", "V", "Jiwon", "Suzy", "Dohyun", "Jisu", "Winter", "Wonyoung", "NingNing"
	};
	static String[] sorted = new String[arr.length];

	public static void sort(int start, int end) {
		if (start < end) {
			sort(start, (start + end) / 2);
			sort((start + end) / 2 + 1, end);
			merge(start, end);
		}
	}
	
	public static void merge(int start, int end) {
		int left = start;
		int right = (start + end) / 2 + 1;
		int index = start;
		
		// 값을 비교하며 sorted 배열에 넣기
		while (left <= (start + end) / 2 && right <= end) {
			if (arr[left].compareTo(arr[right]) < 0) {  // 왼쪽 배열, 오른쪽 배열 요소 중
				sorted[index++] = arr[left++];  // 더 작은 요소를 sorted 배열에 넣는다.
			} else {
				sorted[index++] = arr[right++];
			}
		}
		
		// 나머지 값들 sorted 배열에 넣기
		// 왼쪽 배열부터
		while (left <= (start + end) / 2) {
			sorted[index++] = arr[left++];
		}
		
		// 그 다음 오른쪽 배열
		while (right <= end) {
			sorted[index++] = arr[right++];
		}
		
		// 병합된 부분만 arr에 복사
        for (int i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
	}
	/*
	public static void main(String[] args) {
		sort(0, arr.length - 1);
		// 병합 정렬된 arr 출력
		System.out.println(Arrays.toString(arr));
	}*/
}