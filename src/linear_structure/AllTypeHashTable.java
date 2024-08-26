package linear_structure;
public class AllTypeHashTable {
    Node head = null;

    class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // 연결 리스트의 마지막에 새 노드를 추가한다.
    public void insert(Object key, Object value) {
        Node newNode = new Node(key, value);

        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public Object search(Object key) {
        Node node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;  // 키를 찾지 못한 경우 null 반환
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.println("Key: " + node.key + " , Value: " + node.value);
            node = node.next;
        }
    }

//    public static void main(String[] args) {
//        AllTypeHashTable hashtable = new AllTypeHashTable();
//        hashtable.insert(1000, "apple");
//        hashtable.insert("banana", 2.0f);
//        hashtable.insert(3.14f, 999);
//
//        System.out.println("1000의 값: " + hashtable.search(1000));  // apple
//        System.out.println("banana의 값: " + hashtable.search("banana"));  // 2.0
//        System.out.println("3.14의 값: " + hashtable.search(3.14f));  // 999
//
//        System.out.println("\n해시테이블 전체 출력:");
//        hashtable.display();  // 해시테이블 전체 출력
//    }
}
