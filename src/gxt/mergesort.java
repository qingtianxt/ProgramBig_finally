package gxt;

public class mergesort {
	public static String output = "";//�������
	public double[] mergeSort(int type, double[] array) {
		if(type==1){
			sortMin(array, 0, array.length - 1);
		}
		else{
			sortMax(array, 0, array.length - 1);
		}
		return array;
	}

	public static void sortMin(double[] array, int left, int right) {
		if (left >= right)
			return;
		// �ҳ��м�����
		int center = (left + right) / 2;
		// �����������еݹ�
		sortMin(array, left, center);
		// ���ұ�������еݹ�
		sortMin(array, center + 1, right);
		// �ϲ�
		mergeMin(array, left, center, right);
		print(array);
	}

	/**
	 * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ����
	 * 
	 * @param data
	 *            �������
	 * @param left
	 *            ������ĵ�һ��Ԫ�ص�����
	 * @param center
	 *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
	 * @param right
	 *            ���������һ��Ԫ�ص�����
	 */
	public static void mergeMin(double[] array, int left, int center, int right) {
		// ��ʱ����
		double[] tmpArr = new double[array.length];
		// �������һ��Ԫ������
		int mid = center + 1;
		// third ��¼��ʱ���������
		int third = left;
		// �����������һ��Ԫ�ص�����
		int tmp = left;
		while (left <= center && mid <= right) {
			// ������������ȡ����С�ķ�����ʱ����
			if (array[left] <= array[mid]) {
				tmpArr[third++] = array[left++];
			} else {
				tmpArr[third++] = array[mid++];
			}
		}
		// ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����
		while (mid <= right) {
			tmpArr[third++] = array[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = array[left++];
		}
		// ����ʱ�����е����ݿ�����ԭ������
		// ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩
		while (tmp <= right) {
			array[tmp] = tmpArr[tmp++];
		}
	}
	
	public static void sortMax(double[] array, int left, int right) {
		if (left >= right)
			return;
		// �ҳ��м�����
		int center = (left + right) / 2;
		// �����������еݹ�
		sortMax(array, left, center);
		// ���ұ�������еݹ�
		sortMax(array, center + 1, right);
		// �ϲ�
		mergeMax(array, left, center, right);
		print(array);
	}

	public static void mergeMax(double[] array, int left, int center, int right) {
		// ��ʱ����
		double[] tmpArr = new double[array.length];
		// �������һ��Ԫ������
		int mid = center + 1;
		// third ��¼��ʱ���������
		int third = left;
		// �����������һ��Ԫ�ص�����
		int tmp = left;
		while (left <= center && mid <= right) {
			// ������������ȡ�����ķ�����ʱ����
			if (array[left] >= array[mid]) {
				tmpArr[third++] = array[left++];
			} else {
				tmpArr[third++] = array[mid++];
			}
		}
		// ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����
		while (mid <= right) {
			tmpArr[third++] = array[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = array[left++];
		}
		// ����ʱ�����е����ݿ�����ԭ������
		// ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩
		while (tmp <= right) {
			array[tmp] = tmpArr[tmp++];
		}
	}

	public static void print(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			output += array[i] + " ";
		}
		System.out.println();
		output += "\r\n";
	}

}
