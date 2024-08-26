package linear_structure;
import java.util.NoSuchElementException;

public class Queue {
    private Node front = null;
    private Node rear = null;

    // 연결 리스트로 큐 구현 위해 노드 클래스 구현
    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    // Rear에 value 삽입
    public boolean add(Object value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        return true;
    }

    public boolean offer(Object value) {
        return add(value);
    }

    // Front value 반환 (비었으면 null)
    public Object peek() {
        return (front != null) ? front.data : null;
    }

    // Front value 반환 (비었으면 Exception)
    public Object element() {
        if (front == null) {
            throw new NoSuchElementException("해당하는 값을 큐에서 찾을 수 없습니다.");
        }
        return front.data;
    }

    // Front value 반환 & 삭제 (비었으면 null)
    public Object poll() {
        if (front == null) return null;
        Object data = front.data;
        front = front.next;
        if (front == null) rear = null; // 마지막 노드를 제거한 경우 rear도 null로 설정
        return data;
    }

    // Front value 반환 & 삭제 (비었으면 Exception)
    public Object remove() {
        Object data = poll();
        if (data == null) {
            throw new NoSuchElementException("가장 상단 값이 비어있어 삭제할 수 없습니다.");
        }
        return data;
    }

    // 특정 value 삭제
    public boolean remove(Object value) {
        if (front == null) return false;

        // 첫 번째 노드가 삭제하려는 값인 경우
        if (front.data == null ? value == null : front.data.equals(value)) {
            front = front.next;
            if (front == null) rear = null; // 큐가 비어있다면 rear도 null로 설정
            return true;
        }

        // 그 외의 노드를 순회하며 찾기
        Node current = front;
        Node prev = null;

        while (current != null) {
            if (current.data == null ? value == null : current.data.equals(value)) {
                if (prev != null) {
                    prev.next = current.next;
                }
                if (current == rear) {
                    rear = prev;  // 삭제된 노드가 rear일 경우, rear를 이전 노드로 업데이트
                }
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;  // 끝까지 순회했지만 일치하는 항목을 찾지 못함
    }

    // 전체 데이터 삭제
    public void clear() {
        front = rear = null;
    }

    // 큐의 사이즈 반환
    public int size() {
        int count = 0;
        Node node = front;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    // 큐가 비어있는지 반환
    public boolean isEmpty() {
        return front == null;
    }

    // 특정 값이 큐에 존재하는지 반환
    public boolean contains(Object value) {
        Node node = front;
        while (node != null) {
            if (node.data == null ? value == null : node.data.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

//    public static void main(String[] args) {
//        Queue que = new Queue();
//
//        // 데이터 삽입
//        que.add(100);
//        que.add("Second");
//        que.offer(3.14f);
//        que.offer(400);
//
//        // 상단 데이터 확인
//        Object front1 = que.peek();
//        if (front1 != null) {
//            System.out.println("front by peek: " + front1);
//        } else {
//            System.out.println("front is null...");
//        }
//
//        try {
//            Object front2 = que.element();
//            System.out.println("front by element: " + front2);
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
//
//        // 상단 데이터 삭제
//        Object front3 = que.poll();
//        if (front3 != null) {
//            System.out.println("front by poll: " + front3);
//        } else {
//            System.out.println("front is null...");
//        }
//
//        try {
//            Object front4 = que.remove();
//            System.out.println("front by remove: " + front4);
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
//
//        // 특정 데이터 삭제
//        if (que.remove(3.14f)) {
//            System.out.println("데이터 삭제 성공");
//        } else {
//            System.out.println("데이터 삭제 실패: 값이 존재하지 않습니다.");
//        }
//
//        // 전체 데이터 삭제
//        que.clear();
//
//        // 다시 데이터 넣기
//        que.add(44);
//        que.add("Hello");
//        que.offer(6.13f);
//        que.offer("World");
//
//        // 큐의 사이즈 확인
//        int size = que.size();
//        System.out.println("Size: " + size);
//
//        // 비어있는지 확인
//        if (que.isEmpty()) {
//            System.out.println("큐가 비어있습니다.");
//        } else {
//            System.out.println("큐가 비어있지 않습니다.");
//        }
//
//        // 큐가 특정 값을 포함하는지 확인
//        if (que.contains("Hello")) {
//            System.out.println("큐가 해당 값을 포함합니다.");
//        } else {
//            System.out.println("큐가 해당 값을 포함하지 않습니다.");
//        }
//    }
}