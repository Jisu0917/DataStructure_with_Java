package linear_structure;
public class AllTypeLinkedList {
    Node headNode = null;  // 링크드 리스트의 첫 번째 노드 (head는 실제 데이터 노드가 아니므로 null로 초기화)
    int length = 0;  // 링크드 리스트의 길이

    class Node {
        Object e;  // 만능 타입을 담을 수 있는 변수
        Node nextNode;

        // 일반 노드 생성자
        Node(Object e) {
            this.e = e;
            this.nextNode = null;
        }
    }

    // 링크드 리스트 끝에 새 요소 추가
    public void add(Object element) {
        Node newNode = new Node(element);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node node = headNode;
            while (node.nextNode != null) {
                node = node.nextNode;
            }
            node.nextNode = newNode;
        }
        length++;
    }

    // 특정 인덱스의 노드를 새 요소로 변경
    public void set(int index, Object element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
        }
        Node node = headNode;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        node.e = element;
    }

    // 특정 인덱스의 노드에서 요소 가져오기
    public Object get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
        }
        Node node = headNode;
        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }
        return node.e;
    }

//    public static void main(String[] args) {
//        AllTypeLinkedList mylist = new AllTypeLinkedList();
//        mylist.add(1);               // 정수형 데이터 추가
//        mylist.add("Two");           // 문자열 데이터 추가
//        mylist.add(3.0f);            // 실수형 데이터 추가
//
//        System.out.println(mylist.get(0));  // 1
//        System.out.println(mylist.get(1));  // Two
//        System.out.println(mylist.get(2));  // 3.0
//
//        mylist.set(1, 2.0f);     // 두 번째 요소 변경
//        mylist.set(2, "Three");     // 세 번째 요소 변경
//        System.out.println(mylist.get(1));  // 2.0
//        System.out.println(mylist.get(2));  // Three
//    }
}
