package gxt;

//2017/4/25  ��ѩͮ����ϣ������
public class shellsort {

	public static  String output = "";// ����ȫ�ֱ�����������

	public static double[] shellInsertMax(double[] array) {
		// ����
		int incrementNum = array.length / 2;
		int num = 1;// ѭ���Ĵ���
		// ѭ��ֱ������С��1
		while (incrementNum >= 1) {

			// �����һ�ε�����
			System.out.println("��" + num + "���ĳ���Ϊ:" + incrementNum);
			output += "��" + num + "���ĳ���Ϊ:" + "[" + incrementNum + "]" + "\n\r";

			// �ӵ�һλ��ʼ�����������бȽ�
			for (int i = 0; i < array.length; i++) {

				// ���в�������
				for (int j = i; j < array.length - incrementNum; j = j + incrementNum) {
					if (array[j] < array[j + incrementNum]) {
						double temple = array[j];
						array[j] = array[j + incrementNum];
						array[j + incrementNum] = temple;
					}
				}
			}

			// �����һ������Ľ��
			for (int k = 0; k < array.length; k++) {
				double eps = 1e-10; // ���ȷ�Χ
				if (array[k] - (double) ((int) array[k]) < eps) {
					System.out.print((int) array[k] + " ");
					output += (int) array[k] + " ";
				} else {
					System.out.print(array[k] + " ");
					output += (int) array[k] + " ";
				}
			}
			// �����µ�����
			incrementNum = incrementNum / 2;
			num++;
		}
		return array;
	}

	public static double[] shellInsertMin(double[] array) {
		// ����
		int incrementNum = array.length / 2;
		int num = 1;// ѭ���Ĵ���
		// ѭ��ֱ������С��1
		while (incrementNum >= 1) {

			// �����һ�ε�����
			System.out.println("��" + num + "���ĳ���Ϊ:" + incrementNum);
			output += "��" + num + "���ĳ���Ϊ:" + "[" + incrementNum + "]" + "\n\r";

			// �ӵ�һλ��ʼ�����������бȽ�
			for (int i = 0; i < array.length; i++) {

				// ���в�������
				for (int j = i; j < array.length - incrementNum; j = j + incrementNum) {
					if (array[j] > array[j + incrementNum]) {
						double temple = array[j];
						array[j] = array[j + incrementNum];
						array[j + incrementNum] = temple;
					}
				}
			}

			// �����һ������Ľ��
			for (int k = 0; k < array.length; k++) {
				double eps = 1e-10; // ���ȷ�Χ
				if (array[k] - (double) ((int) array[k]) < eps) {
					System.out.print((int) array[k] + " ");
					output += (int) array[k] + " ";
				} else {
					System.out.print(array[k] + " ");
					output += (int) array[k] + " ";
				}
			}
			// �����µ�����
			incrementNum = incrementNum / 2;
			num++;
		}
		
		return array;
	}

	public static double[] shellSort(int type, double[] array) {
		// ���������ж�˳���L��t��ϣ������

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
