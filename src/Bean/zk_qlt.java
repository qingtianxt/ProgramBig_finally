package Bean;

import java.util.ArrayList;

public class zk_qlt {
	private int dianNum;
	private int bianNum;
	private int[][] bian;
	private ArrayList<String> qlt;
	public zk_qlt(){}
	public zk_qlt(int dianNum,int bianNum,int[][] bian ){
		this.dianNum = dianNum;
		this.bianNum = bianNum;
		this.bian = bian;
	}
	public int getDianNum() {
		return dianNum;
	}
	public void setDianNum(int dianNum) {
		this.dianNum = dianNum;
	}
	public int getBianNum() {
		return bianNum;
	}
	public void setBianNum(int bianNum) {
		this.bianNum = bianNum;
	}
	public int[][] getBian() {
		return bian;
	}
	public void setBian(int[][] bian) {
		this.bian = bian;
	}
	public ArrayList<String> getQlt() {
		return qlt;
	}
	public void setQlt(ArrayList<String> kk) {
		this.qlt = kk;
	}
	
}
