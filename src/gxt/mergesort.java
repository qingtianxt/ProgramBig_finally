package gxt;

public class mergesort {
	public static String output = "";//输出步骤
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
		// 找出中间索引
		int center = (left + right) / 2;
		// 对左边数组进行递归
		sortMin(array, left, center);
		// 对右边数组进行递归
		sortMin(array, center + 1, right);
		// 合并
		mergeMin(array, left, center, right);
		print(array);
	}

	/**
	 * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
	 * 
	 * @param data
	 *            数组对象
	 * @param left
	 *            左数组的第一个元素的索引
	 * @param center
	 *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
	 * @param right
	 *            右数组最后一个元素的索引
	 */
	public static void mergeMin(double[] array, int left, int center, int right) {
		// 临时数组
		double[] tmpArr = new double[array.length];
		// 右数组第一个元素索引
		int mid = center + 1;
		// third 记录临时数组的索引
		int third = left;
		// 缓存左数组第一个元素的索引
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入临时数组
			if (array[left] <= array[mid]) {
				tmpArr[third++] = array[left++];
			} else {
				tmpArr[third++] = array[mid++];
			}
		}
		// 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while (mid <= right) {
			tmpArr[third++] = array[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = array[left++];
		}
		// 将临时数组中的内容拷贝回原数组中
		// （原left-right范围的内容被复制回原数组）
		while (tmp <= right) {
			array[tmp] = tmpArr[tmp++];
		}
	}
	
	public static void sortMax(double[] array, int left, int right) {
		if (left >= right)
			return;
		// 找出中间索引
		int center = (left + right) / 2;
		// 对左边数组进行递归
		sortMax(array, left, center);
		// 对右边数组进行递归
		sortMax(array, center + 1, right);
		// 合并
		mergeMax(array, left, center, right);
		print(array);
	}

	public static void mergeMax(double[] array, int left, int center, int right) {
		// 临时数组
		double[] tmpArr = new double[array.length];
		// 右数组第一个元素索引
		int mid = center + 1;
		// third 记录临时数组的索引
		int third = left;
		// 缓存左数组第一个元素的索引
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最大的放入临时数组
			if (array[left] >= array[mid]) {
				tmpArr[third++] = array[left++];
			} else {
				tmpArr[third++] = array[mid++];
			}
		}
		// 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while (mid <= right) {
			tmpArr[third++] = array[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = array[left++];
		}
		// 将临时数组中的内容拷贝回原数组中
		// （原left-right范围的内容被复制回原数组）
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
