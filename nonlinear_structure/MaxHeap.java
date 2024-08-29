package nonlinear_structure;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private static final int MAX_SIZE = 100;

    MaxHeap() {
    	heap = new int[MAX_SIZE];
    	size = 0;
    }
    
    public void insert(int value) {
    	if (size >= MAX_SIZE) {
    		throw new IllegalStateException("힙이 가득 찼습니다.");
    	}
    	
    	size++;
    	heap[size] = value;
    	heapifyUp(size);
    }
    
    public void heapifyUp(int index) {
    	int parent = index / 2;

    	while (index >= 1 && heap[parent] < heap[index]) {
			swap(parent, index);
			index = parent;
			parent = index / 2;
    	}
    	    	
    }
    
    public int pop() {  // 루트(최댓값) 삭제 함수
    	if (size <= 0) {
    		throw new IllegalStateException("힙이 비었습니다.");
    	}
    	
    	int removed = heap[1];
    	heap[1] = heap[size];
    	size--;
    	heapifyDown(1);

    	return removed;
    }
    
    public void heapifyDown(int index) {
    	
    	while (2 * index < size) {
	    	int leftChild = 2 * index;
	    	int rightChild = 2 * index + 1;
	    	int largeChild = leftChild;  // 기본적으로 왼쪽 자식이 큰 자식인 것으로 간주.
	    	
	    	if (rightChild < size && heap[rightChild] > heap[leftChild]) {  // 자식이 2개 (양쪽)
	    		largeChild = rightChild;
	    	}
	    	
	    	if (heap[index] < heap[largeChild]) {
	    		break;
	    	}
	    	
	    	swap(index, largeChild);
	    	index = leftChild;
    	}
    	   	
    }
    
    public void swap(int from, int to) {
    	int tmp = heap[from];
    	heap[from] = heap[to];
    	heap[to] = tmp;
    }

    public void printTree() {  // 힙을 트리 모양으로 출력해주는 함수
        int level = 0;
        int items = 0;

        for (int i = 0; i < size; i++) {
            if (i == Math.pow(2, level)) {
                System.out.println();
                level++;
                items = (int) Math.pow(2, level);
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
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(80);

        System.out.println("Heap array:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(maxHeap.heap, 0, maxHeap.size)));

        System.out.println("\nHeap tree:");
        maxHeap.printTree();

        maxHeap.pop(); // 루트(최대값) 삭제
        System.out.println("\nHeap tree after deleting root:");
        maxHeap.printTree();
    }*/
}
