package zk_matrixOper;

import Bean.zk_juz;

/**
 * 矩阵运算方法类
 * @author dmego
 * @time 2017-5-4
 */


public class matMethod {
	/**
	 * 矩阵相加
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public zk_juz add_Matrix(zk_juz mat1, zk_juz mat2){
		zk_juz mat = new zk_juz();
		mat.setRow(mat1.getRow());
		mat.setColumn(mat1.getColumn());
		double[][] array = new double[mat.getRow()][mat.getColumn()]; 
		for(int i = 0; i < mat1.getRow();i++){
			for(int j = 0; j < mat1.getColumn(); j++){
				array[i][j] = mat1.getArray()[i][j] + mat2.getArray()[i][j];
			}
		}
		mat.setArray(array);
		return mat;
	}
	
	/**
	 * 矩阵相减
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public zk_juz minus_Matrix(zk_juz mat1, zk_juz mat2){
		zk_juz mat = new zk_juz();
		mat.setRow(mat1.getRow());
		mat.setColumn(mat1.getColumn());
		double[][] array = new double[mat.getRow()][mat.getColumn()]; 
		for(int i = 0; i < mat1.getRow();i++){
			for(int j = 0; j < mat1.getColumn(); j++){
				array[i][j] = mat1.getArray()[i][j] - mat2.getArray()[i][j];
			}
		}
		mat.setArray(array);
		return mat;
	}
	
	/**
	 * 矩阵相乘
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public zk_juz multiply_Matrix(zk_juz mat1, zk_juz mat2){
		zk_juz mat = new zk_juz();
		mat.setRow(mat1.getRow());
		mat.setColumn(mat1.getRow());
		double[][] array = new double[mat.getRow()][mat.getColumn()]; 
		for(int i = 0; i < mat.getRow();i++){
			for(int j = 0; j < mat1.getRow(); j++){
				 for(int k = 0; k < mat1.getColumn(); k++){
					array[i][j] += mat1.getArray()[i][k]*mat2.getArray()[k][j];
				 }
			}
		}
		mat.setArray(array);
		return mat;
	}
	
	/**
	 * 打印矩阵
	 * @param mat
	 */
	public void show_Matrix(zk_juz mat){
		for(int i = 0; i < mat.getRow(); i++){
			System.out.print("(");
			for(int j = 0; j < mat.getColumn(); j++){
				System.out.print(mat.getArray()[i][j]+" ");
			}
			System.out.println(")");
		}
	}
	
	public void check(){
		
	}
}
