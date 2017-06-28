package wzw_hfm;

public class wzw_hfm_cod {
	 public int[] bit;  //编码的数组
	    public int start;  //编码的开始下标
	    public int weight; //权值
	    wzw_hfm_cod(int n){
	        bit = new int[n];
	        start = n-1;
	    }
}