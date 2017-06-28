package gxt;

//2017/4/25  高雪彤——希尔排序
public class shellsort {

	public static  String output = "";// 定义全局变量，输出语句

	public static double[] shellInsertMax(double[] array) {
		// 增量
		int incrementNum = array.length / 2;
		int num = 1;// 循环的次数
		// 循环直到增量小于1
		while (incrementNum >= 1) {

			// 输出这一次的增量
			System.out.println("第" + num + "步的长度为:" + incrementNum);
			output += "第" + num + "步的长度为:" + "[" + incrementNum + "]" + "\n\r";

			// 从第一位开始按照增量进行比较
			for (int i = 0; i < array.length; i++) {

				// 进行插入排序
				for (int j = i; j < array.length - incrementNum; j = j + incrementNum) {
					if (array[j] < array[j + incrementNum]) {
						double temple = array[j];
						array[j] = array[j + incrementNum];
						array[j + incrementNum] = temple;
					}
				}
			}

			// 输出这一次排序的结果
			for (int k = 0; k < array.length; k++) {
				double eps = 1e-10; // 精度范围
				if (array[k] - (double) ((int) array[k]) < eps) {
					System.out.print((int) array[k] + " ");
					output += (int) array[k] + " ";
				} else {
					System.out.print(array[k] + " ");
					output += (int) array[k] + " ";
				}
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
			num++;
		}
		return array;
	}

	public static double[] shellInsertMin(double[] array) {
		// 增量
		int incrementNum = array.length / 2;
		int num = 1;// 循环的次数
		// 循环直到增量小于1
		while (incrementNum >= 1) {

			// 输出这一次的增量
			System.out.println("第" + num + "步的长度为:" + incrementNum);
			output += "第" + num + "步的长度为:" + "[" + incrementNum + "]" + "\n\r";

			// 从第一位开始按照增量进行比较
			for (int i = 0; i < array.length; i++) {

				// 进行插入排序
				for (int j = i; j < array.length - incrementNum; j = j + incrementNum) {
					if (array[j] > array[j + incrementNum]) {
						double temple = array[j];
						array[j] = array[j + incrementNum];
						array[j + incrementNum] = temple;
					}
				}
			}

			// 输出这一次排序的结果
			for (int k = 0; k < array.length; k++) {
				double eps = 1e-10; // 精度范围
				if (array[k] - (double) ((int) array[k]) < eps) {
					System.out.print((int) array[k] + " ");
					output += (int) array[k] + " ";
				} else {
					System.out.print(array[k] + " ");
					output += (int) array[k] + " ";
				}
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
			num++;
		}
		
		return array;
	}

	public static double[] shellSort(int type, double[] array) {
		// 按增量序列对顺序表L作t趟希尔排序

		if ((array == null) || (array.length <= 1)) {
			return null;
		}
		if (type == 1 || type == 2) {

		} else {
			return null;
		}

		if (type == 2) {
			shellInsertMax(array);
		} else {
			shellInsertMin(array);
		}

		return array;
	}

	public static boolean ifNumber(String s) {

		if (s.charAt(0) == 45) {
			for (int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((c >= 48 && c <= 57) || (c == 46)) {
				} else {
					return false;
				}
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((c >= 48 && c <= 57) || (c == 46)) {
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
