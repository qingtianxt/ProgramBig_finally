package Bean;

public class zk_juz {
		private int row; //¾ØÕóĞĞ
		private int column; //¾ØÕóÁĞ
		private double[][] array;
		public zk_juz(){}
		public zk_juz(int row,int column,double[][] array){
			this.row = row;
			this.column = column;
			this.array = array;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}
		public double[][] getArray() {
			return array;
		}
		public void setArray(double[][] array) {
			this.array = array;
		}
		
}
