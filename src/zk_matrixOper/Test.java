package zk_matrixOper;

import Bean.zk_juz;

public class Test {

	public static void main(String[] args) {
		matMethod method = new matMethod();
		double[][] array11 = {{2,3},{4,5},{6,7}};
		double[][] array12 = {{2,3},{4,5},{6,7}};
		double[][] array21 = {{2,4,6},{3,5,7}};
		zk_juz mat1 = new zk_juz(3,2,array11);
		zk_juz mat2 = new zk_juz(2,3,array21);
		//Matrix mat = method.add_Matrix(mat1, mat2);
		zk_juz mat = method.multiply_Matrix(mat1, mat2);
		method.show_Matrix(mat);

	}

}
