package nonlinear_structure;

import java.util.Arrays;

public class MaxHeap {
    private static final int MAX_SIZE = 100;
    private int[] heap;
    private int size;

    public MaxHeap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    // 요소 삽입
    public void insert(int value) {
        if (size >= MAX_SIZE - 1) {
            throw new IllegalStateException("힙이 가득 찼습니다.");
        }
        size++;
        heap[size] = value;
        heapifyUp(size);  // 삽입 후 상향 정렬
    }

    // 상향 정렬
    private void heapifyUp(int index) {
        int parent = index / 2;
        while (index > 1 && heap[parent] < heap[index]) {
            swap(parent, index);
            index = parent;
            parent = index / 2;
        }
    }

    // 루트(최대값) 삭제
    public int pop() {
        if (size == 0) {
            throw new IllegalStateException("힙이 비었습니다.");
        }
        int removed = heap[1]; // 루트 노드의 값
        heap[1] = heap[size]; // 마지막 요소를 루트로 이동
        size--;
        heapifyDown(1); // 루트에서부터 하향 정렬
        return removed;
    }

    // 하향 정렬
    private void heapifyDown(int index) {
        while (index * 2 <= size) {
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;
            int largeChild = leftChild; // 왼쪽 자식을 큰 자식으로 가정

            if (rightChild <= size && heap[rightChild] > heap[leftChild]) {
                largeChild = rightChild;
            }

            if (heap[index] >= heap[largeChild]) {
                break;
            }

            swap(index, largeChild);
            index = largeChild;
        }
    }

    // 요소 교환
    private void swap(int from, int to) {
        int temp = heap[from];
        heap[from] = heap[to];
        heap[to] = temp;
    }

    // 힙을 트리 모양으로 출력
    public void printTree() {
        int level = 0;
        for (int i = 1; i <= size; i++) {
            if (i == (1 << level)) { // 2^level 번째 위치에서 줄 바꿈
                System.out.println();
                level++;
            }
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    /*
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(50);
        maxHeap.insert(90);
        maxHeap.insert(70);
        maxHeap.insert(10);
        maxHeap.insert(40);
        maxHeap.insert(80);

        System.out.println("Heap array:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(maxHeap.heap, 1, maxHeap.size + 1)));

        System.out.println("\nHeap tree:");
        maxHeap.printTree();

        maxHeap.pop(); // 루트(최대값) 삭제
        System.out.println("\nHeap tree after deleting root:");
        maxHeap.printTree();
    }*/
}
