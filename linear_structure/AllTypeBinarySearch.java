package linear_structure;

public class AllTypeBinarySearch {
	public static int binary_search(Comparable[] arr, Comparable target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int middle = start + (end - start) / 2;

			int comparison = target.compareTo(arr[middle]);

			if (comparison == 0) {  // 동일 - 정답!
				return middle;
			} else if (comparison < 0) {  // 타겟이 중간값보다 작다 (Down)
				end = middle - 1;
			} else {  // 타겟이 중간값보다 크다 (Up)
				start = middle + 1;
			}
		}

		return -1;  // 타겟을 찾지 못했을 경우
	}

//	public static void main(String[] args) {
//		String[] arr1 = {"Karina", "Suzy", "Winter", "Wonyoung"};
//
//		int suzyIndex = binary_search(arr1, "Suzy");
//		if (suzyIndex != -1) {
//			System.out.println("수지는 " + (suzyIndex + 1) + "번째 순서입니다.");
//		} else {
//			System.out.println("수지를 찾을 수 없습니다.");
//		}
//		
//		Float[] arr2 = {1.97f, 2.7f, 3.14f, 6.66f, 20.5f, 100.0f};
//
//		int piIndex = binary_search(arr2, 3.14f);
//		if (piIndex != -1) {
//			System.out.println("3.14는 " + (piIndex + 1) + "번째 순서입니다.");
//		} else {
//			System.out.println("3.14를 찾을 수 없습니다.");
//		}
//	}
}