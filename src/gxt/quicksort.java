package gxt;

//2017/4/25 高雪彤——快速排序
public class quicksort {

	public static String output="";//输出步骤
	public double[] quickSort(int type, double[] array) {

		if (type == 1) {
			quickSortMin(array, 0, array.length - 1);// 从小到大
		} else {
			quickSortMax(array, 0, array.length - 1);// 从大到小
		}

		return array;
	}

	public static double[] quickSortMin(double[] array, int start, int end) {
		if (start >= end) {
			return null;
		}

		int i = start;
		int j = end;
		double value = array[i];
		boolean flag = true;
		while (i != j) {
			if (flag) {
				if (value > array[j]) {
					swap(array, i, j);
					flag = false;

				} else {
					j--;
				}
			} else {
				if (value < array[i]) {
					swap(array, i, j);
					flag = true;
				} else {
					i++;
				}
			}
		}
		snp(array);
		quickSortMin(array, start, j - 1);
		quickSortMin(array, i + 1, end);

		return array;

	}

	public static double[] quickSortMax(double[] array, int start, int end) {
		if (start >= end) {
			return null;
		}

		int i = start;
		int j = end;
		double value = array[i];
		boolean flag = true;
		while (i != j) {
			if (flag) {
				if (value < array[j]) {
					swap(array, i, j);
					flag = false;

				} else {
					j--;
				}
			} else {
				if (value > array[i]) {
					swap(array, i, j);
					flag = true;
				} else {
					i++;
				}
			}
		}
		snp(array);
		quickSortMax(array, start, j - 1);
		quickSortMax(array, i + 1, end);

		return array;

	}

	public static void snp(double[] array) {
		System.out.print("步骤为：");
		output += "步骤为：";
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			output += array[i] + " ";
		}
		System.out.println();
		output += "\r\n";
		
	}

	private static void swap(double[] array, int i, int j) {

		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
