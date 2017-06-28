package zk_fourExpCal;
/**
 * 四则表达式计算方法类
 * @author dmego
 * @tme 2017-5-3
 *
 */
import java.util.Stack;

public class fecMethod {
	/**
	 * 中缀表达式转前缀表达式
	 * @param input
	 * @return
	 */
	public Stack<String> toPolishNotation(String input){
		int Len = input.length(); //算术长度
		Stack<String> s1 = new Stack<String>(); //存储运算符的栈s1
		Stack<String> s2 = new Stack<String>(); //存储表达式(中间过程)的栈s2
		String c;
		int index = -1;
		if(Len != 0){
			for(int i = Len - 1; i >= 0 ; --i){
				char cc = input.charAt(i);
				c = String.valueOf(cc);
				if(Character.isDigit(cc)){ //如果字符 c 是数字
					index = checknext1(input, i);
					String number = input.substring(index, i + 1);
					s2.push(number);
					i = index;
				}else if(isOperator(c)){ //如果字符 c 是操作数
					while(!s1.isEmpty() && !s1.peek().equals(")")  && compare(c, s1.peek()) == -1){
						s2.push(s1.pop());
					}
					//否则如果 s1 为空 或者 c 的优先级 s1 栈顶运算符高或相等
					s1.push(c); //压入 栈 s1中	
				}else if( c.equals(")")){
					s1.push(c);
				}else if( c.equals("(")){
					while(!s1.peek().equals(")")){ //如果s1的栈顶元素不为 ")"
						s2.push(s1.pop());
					}
					if(s1.peek().equals(")")){
						s1.pop(); //将 " )" 弹出
					}
				} // --for
			} // --if
			while(!s1.isEmpty()){ //将s1中的剩余的运算符依次弹出，并压入s1中
				s2.push(s1.pop());
			}
		}
		return s2;
		
	}
	/**
	 * 中缀表达式转后缀表达式
	 * @param input
	 * @return
	 */
	public  Stack<String> toReversePolish(String input){
		Stack<String> s1 = new Stack<String>(); //存储运算符的栈s1
		Stack<String> s2 = new Stack<String>(); //存储表达式(中间过程)的栈s2
		String c;
		int index = -1;
			for(int i = 0; i < input.length() ; i++){
				char cc = input.charAt(i);
				c =String.valueOf(cc) ;
				if(Character.isDigit(cc)){ //如果字符 c 是数字
					index = checknext2(input, i);
					String number = input.substring(i,index+1);
					s2.push(number);
					i = index;
				}else if(isOperator(c)){ //如果字符 c 是运算符
					while(true){
						if(s1.isEmpty() || s1.peek().equals("(") || compare(c, s1.peek()) == 1){
							s1.push(c);//如果S1为空或者S1的栈顶元素为 "(",直接入栈
							break;
						}else if(compare(c, s1.peek()) == -1 || compare(c, s1.peek()) == 0 ){
							s2.push(s1.pop());
						}
					}
				}else if( c.equals("(")){
					s1.push(c);
				}else if( c.equals(")")){
					while(!s1.peek().equals("(")){ //如果s1的栈顶元素不为 "("
						s2.push(s1.pop());
					}
					if(s1.peek().equals("(")){
						s1.pop(); //将 "(" 弹出
					}
				} // --for
			} // --if
			while(!s1.isEmpty()){ //将s1中的剩余的运算符依次弹出，并压入s1中
				s2.push(s1.pop());
			}
		Stack<String> s3 = new Stack<String>();
		while(!s2.isEmpty()){
			s3.push(s2.pop());
		}
		return s3;
		
	}
	
	/**
	 * 中缀转前缀——返回下一个运算符的下标 +1
	 * @param input
	 * @param start
	 * @return
	 */
	public int checknext1(String input, int start){
		int index = 0;
		for(int i = start-1; i >= 0;--i){
			char c = input.charAt(i);
			if(!Character.isDigit(c) && c != '.'){
				index = i+1;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 中缀转后缀——返回下一个运算符的下标-1
	 * @param input
	 * @param start
	 * @return
	 */
	public int checknext2(String input, int start){
		int index = 0;
		for(int i = start+1; i <=input.length();i++){
			if(i == input.length()){
				index = i-1;
				break;
			}else{
				char c = input.charAt(i);
				if(!Character.isDigit(c) && c != '.'){
					index = i-1;
					break;
				}	
			}
		}
		return index;
	}
	/**
	 * 计算前缀表达式运算结果
	 * @param polishExp
	 * @return
	 */
	public double calcPolish(Stack<String> Exp){
		Stack<String> s1 = new Stack<String>();	
		while(!Exp.isEmpty()){
			String falg = Exp.pop();
			if(!isOperator(falg)){
				s1.push(falg);
			}else{
				double num1 = Double.parseDouble(s1.pop());
				double num2 = Double.parseDouble(s1.pop());
				double answer = calc(num1, num2, falg);
				System.out.println(num1 +" "+ falg +" "+ num2+" = " + answer);
				s1.push(String.valueOf(answer));
			}
		}
		return Double.parseDouble(s1.pop());
	}
	
	/**
	 * 计算后缀表达式运算结果
	 * @param ReverseExp
	 * @return
	 */
	public double calReverse(Stack<String> Exp){
		Stack<String> s1 = new Stack<String>();	
		while(!Exp.isEmpty()){
			String falg = Exp.pop();
			if(!isOperator(falg)){
				s1.push(falg);
			}else{
				double num1 = Double.parseDouble(s1.pop());
				double num2 = Double.parseDouble(s1.pop());
				double answer = calc(num2, num1, falg);
				System.out.println(num1 +" "+ falg +" "+ num2+" = " + answer);
				s1.push(String.valueOf(answer));
			}
		}
		return Double.parseDouble(s1.pop());
	}
	
	/**
	 * 比较两个运算符的优先级
	 * @param op1
	 * @param op2
	 * @return
	 */
	public static int compare(String op1, String op2){
		if(op1.equals("+") || op1.equals("-") )
		{
			if(op2.equals("+") || op2.equals("-")){
				return 0; //同级返回 0 
			}else if (op2.equals("*") || op2.equals("/")){
				return  -1; //op1 比 op2  优先级低时返回 -1
			}
		}else if(op1.equals("*") || op1.equals("/")){
			if(op2.equals("*") || op2.equals("/")){
				return 0;
			}else if(op2.equals("+") || op2.equals("-")){
				return 1; //op1 比 op2 优先级高时返回 1
			}
		}
		return 0;
	}
	/**
	 * 计算两个操作数的运算结果并返回
	 * @param num1
	 * @param num2
	 * @param op
	 * @return
	 */
	public static double calc(double num1, double num2, String op){
		double answer = 0;
		if(op.equals("+")){
			answer =  num1 + num2;
		}
		else if(op.equals("-")){
			answer = num1 - num2;
		}
		else if(op.equals("*")){
			answer = num1 * num2;
		}else if(op.equals("/")){
			if(num2 == 0)
			System.out.println("出现了被除数为 0 的情况!计算结果为错误结果");
			else 
				answer = num1 / num2;
		}
		return answer;
	}

	/**
	 * 判断字符是否为操作数
	 * @param c
	 * @return
	 */
	public static boolean isOperator(String c){
		if(c.equals("+") || c.equals("-")  || c.equals("*") || c.equals("/")){
			return true;
		}
		return false;
	}
	
	/**
	 * 检查表达式是否符合规范
	 * 具体有以下四种情况
	 * 1.表达式为空
	 * 2.算术表达式中出现了除" + , - , * , / , . " 之外的特殊字符
	 * 3.表达式首字符和尾字符不是数字
	 * 4.出现一个小数点后下一个字符不是数字或者还会出现除运算符之外的特殊字符
	 * @param input
	 */
	public boolean checkinput(String input){
		boolean flag = true;
		if(input == null || input == ""){
			System.out.println("表达式为空");
			//msg = "表达式为空";
			flag = false;
		}else{
			char firstStr = input.charAt(0);
			char endStr = input.charAt(input.length()-1);
			if(!Character.isDigit(firstStr) || !Character.isDigit(endStr)){
				System.out.println("表达式首字符或者尾字符不是数字");
				//msg = "表达式首字符或者尾字符不是数字";
				flag = false;
			}
			for(int i = 1; i < input.length()-1;i++){
				char c = input.charAt(i);
				if(c != '.' && c != '(' && c != ')' && !isOperator(String.valueOf(c)) && !Character.isDigit(c)){
					System.out.println("表达式中出现了除运算符和小数点之外的特殊字符或者空格");
					//msg = "表达式中出现了除运算符、小数点之外的特殊字符或者空格";
					flag = false;
				}
				if(c == '.'){//如果出现小数点
					char cc = input.charAt(i+1);
					if(!Character.isDigit(cc)){
						System.out.println("表达式出现小数点后不是数字的情况");
						//msg = "表达式出现小数点后不是数字的情况";
						flag = false;
					}
					for(int j = i+2; j < input.length(); j++){
						char ccc = input.charAt(j);
						if( ccc == '.'){
							System.out.println("一个操作数中小数点出现两次");
							//msg = "一个操作数中小数点出现两次";
							flag = false;break;
						}else if(isOperator(String.valueOf(ccc))){
							break; 
						}
					}
				}
			}
		}
		return flag;
	}
}
