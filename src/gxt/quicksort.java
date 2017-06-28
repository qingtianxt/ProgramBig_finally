package gxt;

//2017/4/25 ��ѩͮ������������
public class quicksort {

	public static String output="";//�������
	public double[] quickSort(int type, double[] array) {

		if (type == 1) {
			quickSortMin(array, 0, array.length - 1);// ��С����
		} else {
			quickSortMax(array, 0, array.length - 1);// �Ӵ�С
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
		System.out.print("����Ϊ��");
		output += "����Ϊ��";
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
