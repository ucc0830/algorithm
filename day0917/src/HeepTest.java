import java.util.Arrays;

public class HeepTest {
	static class MaxHeapTree{
		int[] datas;
		int MAX_SIZE; 
		int pointer;
		MaxHeapTree(){	
			this(100);
		}
		MaxHeapTree(int maxSize){
			MAX_SIZE = maxSize;
			datas = new int[MAX_SIZE + 1];
			pointer = 0;
		}
		public boolean isFull() {
			if(pointer == MAX_SIZE) {
				return true;
			}else {
				return false;
			}
		}
		public boolean isEmpty() {
			if(pointer == 0) {
				return true;
			}else {
				return false;
			}
		}
		public void insert(int data){
			if(isFull()) {
				System.out.println("overflow");
				return;
			}
			pointer++;
			datas[pointer] = data;
			int idx = pointer;
			while(idx > 1 && datas[idx] > datas[idx/2]) {
				swap(idx, idx/2);
				idx /= 2;
			}
		}
		public int delete() {
			if(isEmpty()) {
				return -1;  // 기본값 반환
			}
			int result = datas[1];
			datas[1] = datas[pointer];
			datas[pointer] = 0;
			pointer--;
			heapify();
			return result;
		}
		private void heapify() {
			int idx = 1;
			while(idx * 2 < pointer) {
				if(datas[idx] >= datas[idx*2] && datas[idx] >= datas[idx*2 +1]  ) {
					break;
				}else {
					if( datas[idx*2] > datas[idx*2 +1]) {
						swap(idx, idx*2);
						idx = idx*2;
					}else {
						swap(idx, idx*2+1);
						idx = idx*2 + 1;
					}
				}
			}
		}
		public void swap(int i, int j) {
			int temp = datas[i];
			datas[i] = datas[j];
			datas[j] = temp;
		}
		void print() {
			System.out.println(Arrays.toString(datas));
		}
		
	}
	public static void main(String[] args) {
		MaxHeapTree heap = new MaxHeapTree();
		heap.insert(3);
		heap.insert(1);
		heap.insert(1);
		heap.insert(5);
		heap.insert(4);
		heap.print();
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		System.out.println(heap.delete());
	}

}
