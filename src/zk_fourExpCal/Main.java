package zk_fourExpCal;

import java.util.Map;
import java.util.Stack;

/**
 * 四则表达式计算主程序
 * @author dmego
 * @time 2017-5-3
 */
public class Main {

	public  static void main(String[] args){
		fecMethod method = new fecMethod();
		//String input= null;
		String input1 = "1+((2+3)*4)-5";
		String input2 = "1.2+(2.2-3*3-5.6+7.5)*(2.2+9.3)/12.9";
		String input3 = " 0 / 3 - ( 2 . 4 - 4 . 5 ) * 2 . 4 + 5 . 6 - ( 4 . 6 + 1 . 2 ) / 1 . 0 ";
		
		String input = input2;
		if(method.checkinput(input)){
			Stack<String> Exp1 = method.toPolishNotation(input);
			Stack<String> Exp11 = method.toPolishNotation(input);
			Stack<String> Exp12 = new Stack<String>();
			while(!Exp11.isEmpty()){
				Exp12.push(Exp11.pop());
			}
			while(!Exp1.isEmpty()){
				System.out.print(Exp1.pop()+ " ");
			}
			System.out.println();
			double num1 = method.calcPolish(Exp12);
			System.out.println(num1);
			System.out.println();
			
			Stack<String> Exp2 = method.toReversePolish(input);
			Stack<String> Exp22 = method.toReversePolish(input);
			while(!Exp2.isEmpty()){
				System.out.print(Exp2.pop()+" ");
			}
			System.out.println();
			double num2 = method.calReverse(Exp22);
			System.out.println(num2);
		}else{
			//System.out.println(msg);
		}
		

		
	}

}
