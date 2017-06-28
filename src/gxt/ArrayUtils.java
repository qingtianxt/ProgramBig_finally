package gxt;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5,2,9,4,8};
		printArray(a);
	}
	public  static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public static void exchangeElements(double[] array, int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}



	public static String output = "";// 输出步骤

	public static double[] heapSort(int type, double[] array) {
		if (type == 1) {

		} else {
			buildMaxHeap(array);
		}

		for (int i = array.length - 1; i >= 1; i--) {
			ArrayUtils.exchangeElements(array, 0, i);
			maxHeap(array, i, 0);
		}

		return array;
	}

	private static void buildMaxHeap(double[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(double[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
			System.out.println("将" + left + "与" + index + "做了交换；");
			output += "将" + left + "与" + index + "做了交换 " + "\r\n";
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
			System.out.println("将" + right + "与" + index + "做了交换；");
			output += "将" + right + "与" + index + "做了交换；" + "\r\n";
		}

		if (index != largest) {
			ArrayUtils.exchangeElements(array, index, largest);

			maxHeap(array, heapSize, largest);
		}
	}

	private static void buildMinHeap(double[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			minHeap(array, array.length, i);
		}
	}

	private static void minHeap(double[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int lowest = index;
		if (left < heapSize && array[left] < array[index]) {
			lowest = left;
			System.out.println("将" + left + "与" + index + "做了交换；");
			output += "将" + left + "与" + index + "做了交换 " + "\r\n";
		}

		if (right < heapSize && array[right] < array[lowest]) {
			lowest = right;
			System.out.println("将" + right + "与" + index + "做了交换；");
			output += "将" + right + "与" + index + "做了交换；" + "\r\n";
		}

		if (index != lowest) {
			ArrayUtils.exchangeElements(array, index, lowest);

			maxHeap(array, heapSize, lowest);
		}
	}
}