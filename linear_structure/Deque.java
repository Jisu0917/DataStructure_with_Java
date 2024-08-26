package linear_structure;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> {
    Node front = null;
    Node rear = null;

    class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public boolean offerFirst(T value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
            return true;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
            return true;
        }
    }

    public void addLast(T value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public boolean offerLast(T value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
            return true;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
            return true;
        }
    }

    public T removeFirst() {
        if (front == null) {
            throw new NoSuchElementException("데이터가 비어있습니다.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        return data;
    }

    public T pollFirst() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        return data;
    }

    public T removeLast() {
        if (rear == null) {
            throw new NoSuchElementException("데이터가 비어있습니다.");
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        return data;
    }

    public T pollLast() {
        if (rear == null) {
            return null;
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        return data;
    }

    public T getFirst() {
        if (front == null) {
            throw new NoSuchElementException("데이터가 비어있습니다.");
        }
        return front.data;
    }

    public T peekFirst() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    public T getLast() {
        if (rear == null) {
            throw new NoSuchElementException("데이터가 비어있습니다.");
        }
        return rear.data;
    }

    public T peekLast() {
        if (rear == null) {
            return null;
        }
        return rear.data;
    }

    public int size() {
        int count = 0;
        Node node = front;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = rear = null;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = front;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            private Node current = rear;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.prev;
                return data;
            }
        };
    }

//    public static void main(String[] args) {
//        Deque<String> deque = new Deque<>();
//        
//        // 데크의 맨 앞에 요소를 삽입
//        deque.addFirst("One");
//        deque.offerFirst("Two");
//        // 데크의 맨 뒤에 요소를 삽입
//        deque.addLast("Three");
//        deque.offerLast("Four");
//        
//        // 데크의 맨 앞 요소를 제거
//        String firstByRemove = deque.removeFirst();
//        System.out.println("first by removeFirst: " + firstByRemove);
//        String firstByPoll = deque.pollFirst();
//        System.out.println("first by pollFirst: " + firstByPoll);
//        // 데크의 맨 뒤 요소를 제거
//        String lastByRemove = deque.removeLast();
//        System.out.println("last by removeLast: " + lastByRemove);
//        String lastByPoll = deque.pollLast();
//        System.out.println("last by pollLast: " + lastByPoll);
//        
//        /*
//         * 데이터 다시 넣기
//         * */
//        deque.addFirst("1st");
//        deque.offerFirst("2nd");
//        deque.addLast("3rd");
//        deque.offerLast("4th");
//        
//        // 데크의 맨 앞 요소 확인
//        String firstByGet = deque.getFirst();
//        System.out.println("first by getFirst: " + firstByGet);
//        String firstByPeek = deque.peekFirst();
//        System.out.println("first by peekFirst: " + firstByPeek);
//        
//        // 데크의 맨 뒤 요소 확인
//        String lastByGet = deque.getLast();
//        System.out.println("last by getLast: " + lastByGet);
//        String lastByPeek = deque.peekLast();
//        System.out.println("last by peekLast: " + lastByPeek);
//        
//        // 데크의 크기 확인
//        int size = deque.size();
//        System.out.println("The size of this deque: " + size);
//        
//        // 데크가 비어있는지 확인
//        if (deque.isEmpty()) {
//            System.out.println("This deque is empty.");
//        } else {
//            System.out.println("This deque is NOT empty.");
//        }
//        
//        // 데크의 요소를 순회하여 출력
//        System.out.println("Print all elements of this deque in order.");
//        Iterator<String> it = deque.iterator();
//        while (it.hasNext()) {
//            String element = it.next();
//            System.out.println(element);
//        }
//        
//        // 데크의 요소를 역순으로 순회하여 출력
//        System.out.println("Print all elements of this deque in reverse order.");
//        Iterator<String> reverse_it = deque.descendingIterator();
//        while (reverse_it.hasNext()) {
//            String element = reverse_it.next();
//            System.out.println(element);
//        }
//    }
}
