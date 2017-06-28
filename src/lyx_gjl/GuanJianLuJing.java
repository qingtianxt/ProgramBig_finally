package lyx_gjl;

import java.util.ArrayList;
import java.util.List;

public class GuanJianLuJing {
	class Graph{
		String[] vexs;//顶点数组
		int[][] arcs;//邻接矩阵
		int vernum;//顶点个数
		int arcnum;//边个数
		int[] indegree;
		int[] tuoPuXuLie;
		boolean isAOV;
		
		
		Arc[] arcdx;
		List<String> guanJianLuJing;
		
		//关键路径相关属性
		int[] ve;
		int[] vl;
//		int[] e;
//		int[] l;
	}
	
	//边类
	class Arc{
		String begin;//起始顶点名
		String end;//终止顶点名
		int weight;//权值
		int e;//最早开始时间
		int l;//最晚开始时间
	}
	
	private Graph G;
	
	
	public static void main(String[] args) {
		GuanJianLuJing g = new GuanJianLuJing();
		String[] vexs = {"v0","v1","v4","v6","v7","v8"};
		String[] arcs = {"v0#1#v1","v1#2#v4","v4#3#v6","v4#5#v7","v6#4#v8","v7#6#v8"};
		g.init(vexs, arcs);
		g.tuoPu();
		System.out.println("拓扑完成");
		g.getGuanJianLuJing();
		System.out.println("关键路径完成");
		System.out.println("关键路径完成2");
	}
	
	public void init(String[] vexs,String[] arcs){
		G = new Graph();
		G.vexs = vexs;
		G.vernum = vexs.length;
		G.arcnum = arcs.length;
		G.tuoPuXuLie = new int[G.vernum];
		G.indegree = new int[G.vernum];
		G.arcs = new int[G.vernum][G.vernum];
		G.arcdx = new Arc[G.vernum];
		for(int i = 0;i < G.vernum;i++){
			for(int j = 0;j < G.vernum;j++){
				G.arcs[i][j] = -1;
			}
			G.indegree[i] = 0;
			G.tuoPuXuLie[i] = -1;
		}
		for(int i = 0;i < arcs.length;i++){
			String[] a = arcs[i].split("#");
			setArc(a[0],a[2],Integer.parseInt(a[1]));
			Arc arc = new Arc();
			arc.begin = a[0];
			arc.end = a[2];
			arc.weight = Integer.parseInt(a[1]);
			G.arcdx[i] = arc;
		}
		tuoPu();
		System.out.println("拓扑完成");
		if(G.isAOV)
			getGuanJianLuJing();
		System.out.println("关键路径完成");
	}
	
	
	
	private void setArc(String b,String e,int w){
		int bn = location(b);
		int en = location(e);
		if(bn == -1 || en == -1){
			System.out.println("顶点未找到");
			return;
		}
		G.arcs[bn][en] = w;
		G.indegree[en]++;
	}
	
	private int location(String s){
		for(int i = 0;i < G.vernum;i++){
			if(G.vexs[i].equals(s)){
				return i;
			}
		}
		return -1;
	}
	
	private void tuoPu(){
		int i = 0;
		while(i < G.vernum){
			int noInIndex = noInVex();
			if(noInIndex == -1){
				G.isAOV = false;
				return;
			}
			G.isAOV = true;
			G.tuoPuXuLie[i++] = noInIndex;
			G.indegree[noInIndex] = -1;
			for(int j = 0;j < G.vernum;j++){
				if(G.arcs[noInIndex][j] != -1){
					G.indegree[j]--;
				}
			}
		}
	}
	
	
	//返回入度为零的顶点的下标
	private int noInVex(){
		for(int i = 0;i < G.vernum;i++){
			if(G.indegree[i] == 0){
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	private void getGuanJianLuJing(){
		G.ve = new int[G.vernum];
		G.vl = new int[G.vernum];
//		G.e = new int[G.arcnum];
//		G.l = new int[G.arcnum];
		
		//事件最早发生时间
		for(int i = 0;i < G.vernum;i++){
			G.ve[i] = 0;
		}
		int k = 0;
		for(int i = G.tuoPuXuLie[k++];i < G.vernum;i = G.tuoPuXuLie[k++]){
			for(int j = 0;j < G.vernum;j++){
				if(G.arcs[j][i] != -1){
					if(G.ve[j] + G.arcs[j][i] > G.ve[i]){
						G.ve[i] = G.ve[j] + G.arcs[j][i];
					}
				}
			}
			if(k >= G.vernum){
				break;
			}
		}
		
		//事件最晚发生时间
		for(int i = 0;i < G.vernum;i++){
			G.vl[i] = G.ve[G.vernum - 1];
		}
		k = G.vernum - 1;
		for(int i = G.tuoPuXuLie[k--];i < G.vernum;i = G.tuoPuXuLie[k--]){
			for(int j = 0;j < G.vernum;j++){
				if(G.arcs[i][j] != -1){
					if(G.vl[i] > G.vl[j] - G.arcs[i][j]){
						G.vl[i] = G.vl[j] - G.arcs[i][j];
					}
				}
			}
			if(k < 0){
				break;
			}
		}
		
		G.guanJianLuJing = new ArrayList<String>();
		
		for(int i = 0;i < G.arcnum;i++){
			G.arcdx[i].e = G.ve[location(G.arcdx[i].begin)];
			G.arcdx[i].l = G.vl[location(G.arcdx[i].end)] - G.arcdx[i].weight;
			if(G.arcdx[i].e == G.arcdx[i].l){
				G.guanJianLuJing.add(G.arcdx[i].begin + "#" + G.arcdx[i].end + "#" + G.arcdx[i].weight);
			}
		}
		
	}
	
	
	
	public String getEL(){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i < G.arcdx.length;i++){
			buffer.append("始点:" + G.arcdx[i].e + "\t终点:" + G.arcdx[i].l + "\t权值：" + G.arcdx[i].weight + "\t最早开始时间：" + G.arcdx[i].e + "\t最晚开始时间：" + G.arcdx[i].l + "#");
		}
		return buffer.toString();
	}
	
	public String getVEL() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i < G.vernum;i++){
			buffer.append("顶点:" + G.vexs[i] + "\t最早发生时间:" + G.ve[i] + "\t最晚发生时间：" + G.vl[i] + "#");
		}
		return buffer.toString();

	}

	public List<String> getGJL(){
		return G.guanJianLuJing;
	}
	
	public boolean isAOV(){
		return G.isAOV;
	}
	
}
