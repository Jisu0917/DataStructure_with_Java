package linear_structure;
public class HashTable {
    Node head = null;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void insert(String key, int value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {  // 마지막 노드까지 탐색
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public int search(String key) {
        Node node = head;
        while (node != null) {  // 마지막 노드까지 탐색
            if (node.key.equals(key)) {  // 문자열 비교는 .equals() 사용
                return node.value;
            }
            node = node.next;
        }
        return -1;  // 마지막 노드까지 탐색했는데 못 찾은 경우
    }

    public void display() {
        Node node = head;
        while (node != null) {  // 마지막 노드까지 탐색
            System.out.println("Key: " + node.key + " , Value: " + node.value);
            node = node.next;
        }
    }

//    public static void main(String[] args) {
//        HashTable hashtable = new HashTable();
//        hashtable.insert("apple", 100);
//        hashtable.insert("banana", 200);
//        hashtable.insert("cherry", 300);
//
//        System.out.println("apple의 값: " + hashtable.search("apple"));  // 100
//        System.out.println("banana의 값: " + hashtable.search("banana"));  // 200
//        System.out.println("cherry의 값: " + hashtable.search("cherry"));  // 300
//
//        System.out.println("\n해시테이블 전체 출력:");
//        hashtable.display();  // 해시테이블 전체 출력
//    }
}
