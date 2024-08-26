package linear_structure;

public class Stack<T> {
    int size = 500;  // 스택의 크기
    Object[] arr = new Object[size];  // 만능 타입 배열 선언
    int length = 0;  // 스택의 현재 길이

    public T push(T element) {
        if (length < size) {
            arr[length] = element;
            length++;
            return element;
        } else {
            return null;  // 스택이 꽉 찼을 때 null 반환
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (length > 0) {
            length--;
            return (T) arr[length];  // Object를 T로 캐스팅
        } else {
            return null;  // 스택이 비어있을 때 null 반환
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (length > 0) {
            return (T) arr[length - 1];  // Object를 T로 캐스팅
        } else {
            return null;  // 스택이 비어있을 때 null 반환
        }
    }

//    public static void main(String args[]) {
//        Stack<Integer> stack_int = new Stack<Integer>();
//        Stack<String> stack_str = new Stack<String>();
//
//        stack_int.push(1);
//        stack_int.push(2);
//        stack_int.push(3);
//        System.out.println(stack_int.pop());  // '3'
//        System.out.println(stack_int.pop());  // '2'
//        System.out.println(stack_int.pop());  // '1'
//
//        stack_str.push("One");
//        stack_str.push("Two");
//        stack_str.push("Three");
//        System.out.println(stack_str.pop());  // 'Three'
//        System.out.println(stack_str.pop());  // 'Two'
//        System.out.println(stack_str.pop());  // 'One'
//    }
}