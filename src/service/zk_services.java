package service;

import java.util.Stack;

import Bean.zk_fec;
import Bean.zk_juz;
import Bean.zk_qlt;
import zk_diGraph.Tarjan;
import zk_fourExpCal.fecMethod;
import zk_matrixOper.matMethod;

public class zk_services {
	
	//四则表达式计算 
	public zk_fec fecService(String input){
		fecMethod fec = new fecMethod();
		Stack<String> Exp = fec.toReversePolish(input);
		Stack<String> Exp22 = fec.toReversePolish(input);
		String Str = "";
		while(!Exp.isEmpty()){
			Str += Exp.pop()+" ";
		}
		double num = fec.calReverse(Exp22);
		zk_fec fecBean =new zk_fec(Str, num);
		return fecBean;
	}
	
	//矩阵运算 
	public zk_juz juzService(zk_juz mat1,zk_juz mat2,String sign){
		matMethod mat = new matMethod();
		zk_juz juzBean = new zk_juz();
		if(sign.equals("+")){
			juzBean = mat.add_Matrix(mat1, mat2);
		}else if(sign.equals("-")){
			juzBean = mat.minus_Matrix(mat1, mat2);
		}else if(sign.equals("*")){
			juzBean = mat.multiply_Matrix(mat1, mat2);
		}
		return juzBean;
	}
	
	//有向图的强连通分量求解
	
}
