// 정수형 자료를 담는 스택 클래스 구현
package linear_structure;

public class Stack {
	int size = 500;  // 스택 사이즈 지정
	int[] arr = new int[size];  // 정수형 배열 선언
	int length = 0;  // 현재 스택의 길이 저장
	
	public int push(int n) {  // 파라미터 n을 스택의 최상단에 추가
		if (length < size) {
			arr[length] = n;
			length++;
			return 0;
		} else {
			return -1;
		}
	}
	
	public int pop() {  // 스택의 최하단에 있는 정수형 자료를 제거
		if (length > 0) {
			length--;
			return arr[length];
		} else {
			return -1;
		}
	}
	
	public int peek() {  // 스택의 최하단에 있는 정수형 자료를 반환 (제거x)
		if (length > 0) {
			return arr[length - 1];
		} else {
			return -1;
		} 
	}
	
//	public static void main(String[] args) {
//		Stack stack = new Stack();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		System.out.println(stack.pop());  // '3'
//		System.out.println(stack.pop());  // '2'
//		System.out.println(stack.pop());  // '1'
//	}
}